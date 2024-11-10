package network.server;

import javafx.application.Platform;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import network.message.*;
import ui.Main;
import ui.scene.GamePlay;
import ui.scene.RoomRole;

import java.io.*;
import java.net.*;
import java.util.Enumeration;

public class Server {
    private ServerSocket serverSocket;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    private Socket clientSocket;
    private Thread clientHandlerThread;


    public String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    // We're only interested in IPv4 addresses
                    if (addr.getHostAddress().contains(".")) {
                        return addr.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "127.0.0.1"; // Fallback to localhost if no other address found
    }

    public void start(TeamColor teamColor, String name) {
        try {
            // Set P1
            GameLogic.getInstance().setPlayer1(new Player(teamColor, name));

            // Start Socket
            serverSocket = new ServerSocket(65301);
            String localIP = getLocalIPAddress();
            System.out.println("Server started at " + localIP + ":" + serverSocket.getLocalPort());

            // Client connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            new Thread(() -> handleClient(clientSocket)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleClient(Socket clientSocket) {
        try{
            MessageObject msg;
            while ((msg = (MessageObject) in.readObject()) != null) {
                if (msg instanceof Connect) {

                    // On Connect assign Color for player2
                    if (GameLogic.getInstance().getPlayer1().getTeamColor() == TeamColor.BLACK){
                        GameLogic.getInstance().setPlayer2(new Player(TeamColor.WHITE, ((Connect) msg).getName()));
                    }else {
                        GameLogic.getInstance().setPlayer2(new Player(TeamColor.BLACK, ((Connect) msg).getName()));
                    }

                    // Random Who go first
                    double rng = Math.random();
                    if(rng > 0.5){
                        GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer1());
                    }else {
                        GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer2());
                    }

                    Platform.runLater(() ->{
                        Main.stage.setScene(GamePlay.getSceneInstance(RoomRole.CREATOR, GameLogic.getInstance().getPlayer1(), GameLogic.getInstance().getPlayer2()));
                        System.out.println("RUN LATER");
                        GamePlay.getInstance(RoomRole.CREATOR, GameLogic.getInstance().getPlayer1(), GameLogic.getInstance().getPlayer2()).updateLayout();
                    });

                    // Sent Data to Client
                    this.sendMessageToClient(out, new RoomInfo(GameLogic.getInstance()));

                }else if(msg instanceof Play){
                    GameLogic.getInstance().getCurrentPlayer().play(((Play) msg).getChessIdx(), ((Play) msg).getColumn(), ((Play) msg).getRow());
                    if(GameLogic.getInstance().getCurrentPlayer().isPlayDone() && !GameLogic.getInstance().isGameOver()) {
                        GameLogic.getInstance().getCurrentPlayer().setPlayDone(false);
                        GameLogic.getInstance().goToNextPlayer();
                    }

                    GamePlay.getInstance().updateLayout();
                    this.sendMessageToClient(out, new RoomInfo(GameLogic.getInstance()));
                }


            }
        } catch (EOFException e) {

            System.out.println("Client Disconnect: " + clientSocket.getRemoteSocketAddress());
            System.exit(9999);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketAddress getAddress() {
        if (serverSocket != null) {
            return serverSocket.getLocalSocketAddress();
        }
        return null;
    }

    public void sendMessageToClient(ObjectOutputStream out, MessageObject message) throws IOException {
        System.out.println("SENT");
        out.writeObject(message);
        out.flush();
    }

    private void cleanup() {
        try {
            // 1. Close input stream if it exists
            if (in != null) {
                in.close();
                in = null;
            }

            // 2. Close output stream if it exists
            if (out != null) {
                out.close();
                out = null;
            }

            // 3. Close client socket if it exists and is still open
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
                clientSocket = null;
            }

            // 4. Close server socket if it exists and is still open
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                serverSocket = null;
            }

            // 5. Handle client handler thread cleanup
            if (clientHandlerThread != null) {
                clientHandlerThread.interrupt(); // Signal thread to stop
                try {
                    // Wait up to 1 second for thread to finish
                    clientHandlerThread.join(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                clientHandlerThread = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
