package network.server;

import logic.entity.Player;
import logic.game.TeamColor;
import network.message.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    private ServerSocket serverSocket;
    private Room room;
    private RoomInfo roomInfo;

    public void start(TeamColor teamColor, String name) {
        try {
            this.room = new Room();
            room.setPlayer1(new Player(teamColor, name));
            serverSocket = new ServerSocket(65301);

            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                new Thread(() -> handleClient(clientSocket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            MessageObject msg;
            while ((msg = (MessageObject) in.readObject()) != null) {
                if (msg instanceof Connect) {
                    if (room.getPlayer1().getTeamColor() == TeamColor.BLACK){
                        room.setPlayer2(new Player(TeamColor.WHITE, ((Connect) msg).getName()));
                    }else {
                        room.setPlayer2(new Player(TeamColor.BLACK, ((Connect) msg).getName()));
                    }

                    double rng = Math.random();
                    if(rng > 0.5){
                        room.getGameInstance().setCurrentPlayer(room.getPlayer1());

                    }else {
                        room.getGameInstance().setCurrentPlayer(room.getPlayer2());
                    }
                    this.roomInfo = new RoomInfo(this.room);
                    this.roomInfo.setCurrentPlayer(new PlayerInfo(room.getGameInstance().getCurrentPlayer()));
                    this.sendMessageToClient(out, this.roomInfo);

                }else if(msg instanceof Play){
                    this.room.getGameInstance().getCurrentPlayer().play(((Play) msg).getChessIdx(), ((Play) msg).getColumn(), ((Play) msg).getRow());
                    this.roomInfo.setCurrentPlayer(new PlayerInfo(room.getGameInstance().getCurrentPlayer()));
                    this.sendMessageToClient(out, this.roomInfo);
                }


            }
        } catch (EOFException e) {

            System.out.println("Client Disconnect: " + clientSocket.getRemoteSocketAddress());

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

    // Add a method for sending messages to the client
    private void sendMessageToClient(ObjectOutputStream out, MessageObject message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

}
