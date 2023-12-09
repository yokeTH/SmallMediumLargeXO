package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.scene.Menu;
import ui.scene.SelectColor;

public class Main extends Application {
    public static Scene c1 = new Scene(new Menu(), 400, 600);
    public static Scene c2 = new Scene(new SelectColor());
    public static Stage stage;
    @Override
    public void start(Stage stage) {
        Main.stage = stage;

        stage.setResizable(false);
        stage.setTitle("XO Game");
        stage.setScene(Main.c1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
