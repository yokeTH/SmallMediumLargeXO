package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ui.Main;
import ui.components.Logo;
import ui.components.TextButton;

public class Menu extends VBox {

    private static Scene sceneInstance;
    public Menu() {

        Logo logo = new Logo();

        TextButton playOfflineButton = new TextButton("PLAY OFFLINE");
        playOfflineButton.setOnMouseClicked(event->{
            Main.stage.setScene(GamePlay.getSceneInstance());
        });


        TextButton createRoomButton = new TextButton("CREATE ROOM");
        createRoomButton.setOnMouseClicked(event->{
            Main.stage.setScene(CreateRoom.getSceneInstance());
        });

        TextButton joinRoomButton = new TextButton("JOIN ROOM");
        joinRoomButton.setOnMouseClicked(event -> {
            Main.stage.setScene(JoinRoom.getSceneInstance());
        });

        TextButton quitButton = new TextButton("QUIT");
        quitButton.setOnMouseClicked(mouse->{
            Main.stage.close();
        });


        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(logo, playOfflineButton, createRoomButton, joinRoomButton, quitButton);
    }

    public static Scene getSceneInstance(){
        if(sceneInstance == null){
            sceneInstance = new Scene(new Menu(), 854, 480);
        }
        return sceneInstance;
    }
}
