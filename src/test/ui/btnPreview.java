package test.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.components.TextButton;

public class btnPreview extends Application {
    @Override
    public void start(Stage stage) {

        TextButton btn = new TextButton("TEST");

        Scene scene = new Scene(btn);
        stage.setTitle("TEST x Chess");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
