package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.SVGViewBase;

public class JoinerWaitingRoom extends GridPane {
    private static Scene sceneInstance;
    JoinerWaitingRoom(String roomCode){
        Text roomNameText = new Text("Room Name \"" + roomCode + "\"");

        Label selectColorLabel = new Label("Select Color : ");
        SVGViewBase team = (true)? new LargeXChess(72) : new LargeOChess(72);

        this.setAlignment(Pos.CENTER);

        this.add(roomNameText, 0,0,2,1);
        Text roomCodeText = new Text("Room Code : " + roomCode);
        this.add(roomCodeText, 0,1,2,1);
        this.add(selectColorLabel,0 , 3);
        this.add(team, 1,3);
    }
    public static Scene getSceneInstance(String roomName){
        if(JoinerWaitingRoom.sceneInstance == null){
            JoinerWaitingRoom.sceneInstance = new Scene(new JoinerWaitingRoom(roomName), 854, 480);
        }
        return JoinerWaitingRoom.sceneInstance;
    }
}

