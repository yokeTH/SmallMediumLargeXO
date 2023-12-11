package ui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.scene.CreateRoom;
import ui.scene.Menu;
import ui.scene.SelectColor;

public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) {
        Main.stage = stage;

        stage.setResizable(false);
        stage.setTitle("XO Game");
        stage.setScene(Menu.getSceneInstance());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
