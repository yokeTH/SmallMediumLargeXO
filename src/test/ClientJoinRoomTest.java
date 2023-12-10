package test;

import logic.game.TeamColor;
import network.client.Client;
import network.message.Connect;
import network.message.RoomInfo;

import java.io.IOException;
import java.util.Scanner;

public class ClientJoinRoomTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Client client = new Client();
        client.connect("0.0.0.0", 65301);

        client.send(new Connect("P2...."));

        System.out.println((client.receive()).toString());

        client.receive();
        client.disconnect();
    }
}
