package test;

import network.client.Client;
import network.message.Connect;
import network.message.RoomInfo;

import java.io.IOException;
import java.util.Scanner;

public class ClientJoinRoomTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        client.connect("0.0.0.0", 65301);

        System.out.print("Room No. :");
        int roomId = sc.nextInt();

        System.out.println("RoomID: " + roomId);
        client.send(new Connect(roomId));

        System.out.println((client.receive()).toString());

        client.receive();
        client.disconnect();
    }
}
