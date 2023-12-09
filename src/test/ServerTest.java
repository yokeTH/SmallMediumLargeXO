package test;

import network.server.Server;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(65301);
    }
}
