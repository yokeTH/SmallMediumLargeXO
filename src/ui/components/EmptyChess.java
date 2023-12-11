package ui.components;

import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class EmptyChess extends SVGViewBase {
    @Override
    protected void init() {

    }

    public EmptyChess(){
        this.setMaxSize(120, 120);
        this.setMinSize(120,120);
//        this.setStyle(
//                "-fx-background-color: #dddddd;" +
//                "-fx-background-radius: 12;");

    }
}
