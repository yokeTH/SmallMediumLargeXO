package ui;

import javafx.application.Application;
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

        Menu root = new Menu();
        Scene scene = new Scene(root, 854,480);

        stage.setResizable(false);
        stage.setTitle("XO Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
