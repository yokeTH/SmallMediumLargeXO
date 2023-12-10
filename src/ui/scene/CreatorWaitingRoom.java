package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import logic.game.TeamColor;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.SVGViewBase;

public class CreatorWaitingRoom extends GridPane {
    private static Scene sceneInstance;
    CreatorWaitingRoom(String roomName, TeamColor teamColor){
        Text roomNameText = new Text("Room Name \"" + roomName + "\"");
        Text waitText = new Text("Waiting for Opponent...");

        Label selectColorLabel = new Label("Select Color : ");
        SVGViewBase team = (teamColor == TeamColor.BLACK)? new LargeXChess(72) : new LargeOChess(72);

        this.setAlignment(Pos.CENTER);

        this.add(roomNameText, 0,0,2,1);
        Text roomCodeText = new Text("Room Code : " + 00000);
        this.add(roomCodeText, 0,1,2,1);
        this.add(waitText, 0, 2, 2, 1);
        this.add(selectColorLabel,0 , 3);
        this.add(team, 1,3);
    }
    public static Scene getSceneInstance(RoomRole r, String roomName, TeamColor teamColor){
        if(CreatorWaitingRoom.sceneInstance == null){
            CreatorWaitingRoom.sceneInstance = new Scene(new CreatorWaitingRoom(roomName, teamColor), 854, 480);
        }
        return CreatorWaitingRoom.sceneInstance;
    }
}

