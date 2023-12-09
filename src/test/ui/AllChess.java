package test.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.components.*;
import ui.transition.PopTransitionController;

public class AllChess extends Application {
    @Override
    public void start(Stage stage) {
        LargeXChess largeXChess = new LargeXChess(100);
        MediumXChess mediumXChess = new MediumXChess(100);
        SmallXChess smallXChess = new SmallXChess(100);

        LargeOChess largeOChess = new LargeOChess(100);
        MediumOChess mediumOChess = new MediumOChess(100);
        SmallOChess smallOChess = new SmallOChess(100);

        GridPane root = new GridPane();
        root.add(new Pane(largeXChess),0,0);
        root.add(new Pane(mediumXChess),1,0);
        root.add(new Pane(smallXChess),2,0);

        root.add(new Pane(largeOChess),0,1);
        root.add(new Pane(mediumOChess),1,1);
        root.add(new Pane(smallOChess),2,1);

        Scene scene = new Scene(root,300,200);
        stage.setTitle("TEST x Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
