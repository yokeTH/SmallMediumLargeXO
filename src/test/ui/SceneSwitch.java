package test.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.scene.Menu;
import ui.scene.SelectColor;

public class SceneSwitch extends Application {
    public static Scene c1 = new Scene(new Menu(), 300, 200);
    public static Scene c2 = new Scene(new SelectColor());
    public static Stage stage;
    @Override
    public void start(Stage stage) {
        SceneSwitch.stage = stage;

        stage.setTitle("TEST x Chess");
        stage.setScene(SceneSwitch.c1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
