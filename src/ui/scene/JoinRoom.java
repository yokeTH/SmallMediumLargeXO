package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ui.Main;
import ui.components.TextButton;

import java.io.IOException;

public class JoinRoom extends GridPane {
    private static Scene sceneInstance;
    public JoinRoom() {
        Text title = new Text("JOIN ROOM");
        title.setFont(Font.font("Itim",48));
        title.setTextAlignment(TextAlignment.CENTER);

        Label roomCodeLabel = new Label("Address");
        roomCodeLabel.setFont(Font.font("Itim",24));
        Label playerNameLabel = new Label("Player Name");
        playerNameLabel.setFont(Font.font("Itim",24));

        TextField roomCodeField = new TextField();
        TextField playerNameField = new TextField();

        // Create buttons
        TextButton joinButton = new TextButton("JOIN", 150);
        TextButton backButton = new TextButton("BACK", 150);

        // Setup join button action
        joinButton.setOnMouseClicked(event -> {
            try {
                Main.stage.setScene(JoinerWaitingRoom.getSceneInstance(roomCodeField.getText(), playerNameField.getText()));
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        // Setup back button action
        backButton.setOnMouseClicked(event -> {
            clearScene();
            Main.stage.setScene(Menu.getSceneInstance());
        });

        // Create HBox for buttons
        HBox buttonBox = new HBox(10); // 10 is the spacing between buttons
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(joinButton, backButton);

        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        this.add(title, 0, 0, 2, 1);
        this.add(roomCodeLabel, 0, 1);
        this.add(playerNameLabel, 0, 2);
        this.add(roomCodeField, 1, 1);
        this.add(playerNameField, 1, 2);
        this.add(buttonBox, 0, 4, 2, 1); // Span both columns
    }


    public static Scene getSceneInstance(){
        if(JoinRoom.sceneInstance == null){
            JoinRoom.sceneInstance = new Scene(new JoinRoom(), 854, 480);
        }
        return JoinRoom.sceneInstance;
    }

    private void clearScene() {
        sceneInstance = null;
    }

}
