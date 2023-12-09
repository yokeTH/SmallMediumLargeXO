package ui.transition;

import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import ui.components.SVGViewBase;

public class PopTransitionController {

    private final ScaleTransition scaleTransition;
    public PopTransitionController(SVGViewBase n){
        scaleTransition = new ScaleTransition();
        scaleTransition.setNode(n);
        scaleTransition.setCycleCount(1);
        scaleTransition.setDuration(Duration.millis(200));

        scaleTransition.setFromX(1.2);
        scaleTransition.setToX(1);

        scaleTransition.setFromY(1.2);
        scaleTransition.setToY(1);
    }

    public void play(){
        this.scaleTransition.playFromStart();
    }
}
