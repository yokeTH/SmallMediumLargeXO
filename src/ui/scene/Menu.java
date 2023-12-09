package ui.scene;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import test.ui.SceneSwitch;
import ui.Main;
import ui.components.TextButton;

public class Menu extends GridPane {

    public Menu() {
        TextButton singlePlayerButton = new TextButton("Singleplayer");

        singlePlayerButton.setOnMouseClicked(mouse->{
            Main.stage.setScene(Main.c2);
        });


        TextButton multiPlayerButton = new TextButton("Multiplayer");
        TextButton settingButton = new TextButton("Select Color");
        TextButton closeButton = new TextButton("Close");

        closeButton.setOnMouseClicked(mouse->{
            Main.stage.close();
        });


        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
        this.add(singlePlayerButton,0,0);
        this.add(multiPlayerButton,0,1);
        this.add(settingButton,0,2);
        this.add(closeButton,0,3);
    }
}
