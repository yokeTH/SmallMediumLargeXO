package test;

import network.client.Client;
import network.message.Connect;
import network.message.RoomInfo;

import java.io.IOException;

public class ClientCreateRoomTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Client client = new Client();
        client.connect("0.0.0.0", 65301);
        client.send(new Connect());
        System.out.println(((RoomInfo) client.receive()).toString());
        client.receive();
        client.disconnect();
    }
}
