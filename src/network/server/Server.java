package network.server;

import javafx.application.Platform;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import network.message.*;
import ui.Main;
import ui.scene.GamePlayOnline;
import ui.scene.RoomRole;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    private ServerSocket serverSocket;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    public void start(TeamColor teamColor, String name) {
        try {

            // Set P1
            GameLogic.getInstance().setPlayer1(new Player(teamColor, name));

            // Start Socket
            serverSocket = new ServerSocket(65301);
            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

            // Client connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
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
                        Main.stage.setScene(GamePlayOnline.getSceneInstance(RoomRole.CREATOR, GameLogic.getInstance().getPlayer1().getTeamColor(), GameLogic.getInstance().getPlayer1().getName()));
                    });
                    // Sent Data to Client
                    this.sendMessageToClient(out, new RoomInfo(GameLogic.getInstance()));

                }else if(msg instanceof Play){
                    GameLogic.getInstance().getCurrentPlayer().play(((Play) msg).getChessIdx(), ((Play) msg).getColumn(), ((Play) msg).getRow());
                    System.out.println(GameLogic.getInstance().getPlayer2().getBaseChessArrayList());
                    if(GameLogic.getInstance().getCurrentPlayer().isPlayDone()){
                        GameLogic.getInstance().goToNextPlayer();
                    }
                    GamePlayOnline.updateLayout();
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

}
