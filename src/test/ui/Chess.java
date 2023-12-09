package test.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import ui.components.LargeXChess;
import ui.transition.PopTransitionController;

public class Chess extends Application {
    @Override
    public void start(Stage stage) {
        LargeXChess x3 = new LargeXChess(120);

        Scene scene = new Scene(x3);
        stage.setTitle("TEST x Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
