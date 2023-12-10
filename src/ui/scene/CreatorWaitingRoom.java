package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import logic.game.TeamColor;
import network.server.Server;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.SVGViewBase;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class CreatorWaitingRoom extends GridPane {
    private static Scene sceneInstance;
    public static Server server;
    CreatorWaitingRoom(String playerName, TeamColor teamColor) throws UnknownHostException {
        server = new Server();
//        server.start(teamColor, playerName);
        new Thread(()->server.start(teamColor, playerName)).start();


        Text roomNameText = new Text("Player Name \"" + playerName + "\"");
        Text waitText = new Text("Waiting for Opponent...");

        Label selectColorLabel = new Label("Select Color : ");
        SVGViewBase team = (teamColor == TeamColor.BLACK)? new LargeXChess(72) : new LargeOChess(72);

        this.setAlignment(Pos.CENTER);

        this.add(roomNameText, 0,0,2,1);
        Text roomCodeText = new Text("Room Address : " + InetAddress.getLocalHost().getHostAddress());
        this.add(roomCodeText, 0,1,2,1);
        this.add(waitText, 0, 2, 2, 1);
        this.add(selectColorLabel,0 , 3);
        this.add(team, 1,3);
    }
    public static Scene getSceneInstance(RoomRole r, String playerName, TeamColor teamColor) throws UnknownHostException {
        if(CreatorWaitingRoom.sceneInstance == null){
            CreatorWaitingRoom.sceneInstance = new Scene(new CreatorWaitingRoom(playerName, teamColor), 854, 480);
        }
        return CreatorWaitingRoom.sceneInstance;
    }
}

