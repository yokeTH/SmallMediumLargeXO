package network.client;

import network.message.Connect;
import network.message.MessageObject;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void connect(String ip, int port) throws IOException, ClassNotFoundException {
        clientSocket = new Socket(ip, port);
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    public void send(MessageObject msg) throws IOException {
        out.writeObject(msg);
        out.flush(); // Ensure the data is sent immediately
    }

    public MessageObject receive() throws IOException, ClassNotFoundException {
        return (MessageObject) in.readObject();
    }

    public void disconnect() {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
