package network.server;

import network.message.Connect;
import network.message.MessageObject;
import network.message.RoomInfo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    private ServerSocket serverSocket;
    private HashMap<Integer,Room> rooms;

    public void start(int port) {
        try {
            this.rooms = new HashMap<>();
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Handle the client in a separate thread
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        Room room = null;
        try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            MessageObject msg;
            while ((msg = (MessageObject) in.readObject()) != null) {
                if (msg instanceof Connect) {
                    System.out.println(((Connect) msg).getRoomId());
                    if(((Connect) msg).getRoomId() == 0){
                        room = new Room();
                        System.out.println(room.toString());
                        this.rooms.put(room.getRoomId(), room);
                        this.sendMessageToClient(out, new RoomInfo(room));
                        System.out.println(clientSocket.getRemoteSocketAddress() + " Create Room: " + room);
                    }else{
                        room = this.rooms.get(((Connect) msg).getRoomId());
                        this.sendMessageToClient(out, new RoomInfo(room));
                        System.out.println(clientSocket.getRemoteSocketAddress() + "Join Room: " + room.toString());
                    }
                    System.out.println(rooms.toString());
                }
            }
        } catch (EOFException e) {
            System.out.println("Client Disconnect: " + clientSocket.getRemoteSocketAddress());
            if(room != null) this.rooms.remove(room);
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

//    public createRoom(){
//
//    }
}
