package ui.components;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;

public class Logo extends StackPane {
    public Logo(){
        setupLayout();
    }

    public Logo(double width){
        this.getTransforms().add(new Scale(width/250, width/250) );
        setupLayout();
    }

    private void setupLayout(){
        this.setAlignment(Pos.CENTER);
        LargeXChess x0 = new LargeXChess(125);
        LargeXChess x1 = new LargeXChess(125);
        LargeOChess o0 = new LargeOChess(100);
        LargeOChess o1 = new LargeOChess(100);

        x1.setTranslateX(-75);
        x1.setTranslateY(-12);
        o1.setTranslateX(-25);
        x0.setTranslateX(50);
        x0.setTranslateY(-12);
        o0.setTranslateX(100);

        this.getChildren().setAll(o0, o1, x0, x1);

    }
}
