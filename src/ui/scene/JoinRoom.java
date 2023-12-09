package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ui.Main;
import ui.components.TextButton;

public class JoinRoom extends GridPane {
    private static Scene sceneInstance;
    public JoinRoom(){
        Text title = new Text("JOIN ROOM");
        title.setFont(Font.font("Itim",48));
        title.setTextAlignment(TextAlignment.CENTER);

        Label roomCodeLabel = new Label("Room Code");
        roomCodeLabel.setFont(Font.font("Itim",24));
        Label playerNameLabel = new Label("Player Name");
        playerNameLabel.setFont(Font.font("Itim",24));

        TextField roomCodeField = new TextField();
        TextField playerNameField = new TextField();

        TextButton joinButton = new TextButton("JOIN", 360);
        joinButton.setOnMouseClicked(event -> {
            Main.stage.setScene(JoinerWaitingRoom.getSceneInstance(roomCodeField.getText()));
        });

        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        this.add(title, 0,0,2,1);
        this.add(roomCodeLabel, 0,1);
        this.add(playerNameLabel, 0,2);
        this.add(joinButton, 0, 4, 2,1);

        this.add(roomCodeField, 1,1);
        this.add(playerNameField, 1 ,2);
    }


    public static Scene getSceneInstance(){
        if(JoinRoom.sceneInstance == null){
            JoinRoom.sceneInstance = new Scene(new JoinRoom(), 854, 480);
        }
        return JoinRoom.sceneInstance;
    }
}
