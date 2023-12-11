package test;

import logic.game.TeamColor;
import network.server.Server;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(TeamColor.WHITE, "I am as Server");
    }
}
