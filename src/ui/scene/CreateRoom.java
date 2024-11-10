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
import logic.game.TeamColor;
import ui.Main;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.TextButton;

import java.net.UnknownHostException;

public class CreateRoom extends GridPane {
    private static Scene sceneInstance;

    public CreateRoom() {
        Text title = new Text("CREATE ROOM");
        title.setFont(Font.font("Itim",48));
        title.setTextAlignment(TextAlignment.CENTER);

        Label roomNameLabel = new Label("Room Name");
        roomNameLabel.setFont(Font.font("Itim",24));
        Label playerNameLabel = new Label("Player Name");
        playerNameLabel.setFont(Font.font("Itim",24));
        Label selectLabel = new Label("Select");
        selectLabel.setFont(Font.font("Itim",24));

        TextField roomNameField = new TextField();
        TextField playerNameField = new TextField();

        LargeXChess x = new LargeXChess(72);
        x.setOnMouseClicked(event -> {
            try {
                Main.stage.setScene(CreatorWaitingRoom.getSceneInstance(RoomRole.CREATOR, playerNameField.getText(), TeamColor.BLACK));
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        });

        LargeOChess o = new LargeOChess(72);
        o.setOnMouseClicked(event -> {
            try {
                Main.stage.setScene(CreatorWaitingRoom.getSceneInstance(RoomRole.CREATOR, playerNameField.getText(), TeamColor.WHITE));
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        });

        HBox xo = new HBox(x, o);

        // Add back button
        TextButton backButton = new TextButton("BACK", 150);
        backButton.setOnMouseClicked(event -> {
            clearScene();
            Main.stage.setScene(Menu.getSceneInstance());
        });

        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        this.add(title, 0, 0, 2, 1);
        this.add(roomNameLabel, 0, 1);
        this.add(playerNameLabel, 0, 2);
        this.add(selectLabel, 0, 3);
        this.add(roomNameField, 1, 1);
        this.add(playerNameField, 1, 2);
        this.add(xo, 1, 3);
        this.add(backButton, 0, 4, 2, 1);
    }

    private void clearScene() {
        sceneInstance = null;
    }

    public static Scene getSceneInstance() {
        if(CreateRoom.sceneInstance == null) {
            CreateRoom.sceneInstance = new Scene(new CreateRoom(), 854, 480);
        }
        return CreateRoom.sceneInstance;
    }
}