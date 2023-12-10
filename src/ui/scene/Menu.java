package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import ui.Main;
import ui.components.TextButton;

public class Menu extends GridPane {

    public Menu() {

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

        TextButton helpButton = new TextButton("HELP");
        TextButton credits = new TextButton("CREDITS");

        TextButton quitButton = new TextButton("QUIT");
        quitButton.setOnMouseClicked(mouse->{
            Main.stage.close();
        });


        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
        this.add(playOfflineButton,0,1);
        this.add(createRoomButton,0,2);
        this.add(joinRoomButton,0,3);
        this.add(helpButton,0,4);
        this.add(credits,0,5);
        this.add(quitButton,0,6);
    }
}
