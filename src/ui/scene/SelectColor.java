package ui.scene;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ui.components.TextButton;
import ui.Main;

public class SelectColor extends GridPane {

    public SelectColor() {
        TextButton c = new TextButton("Scene 2");

        this.getChildren().addAll(c);
    }
}
