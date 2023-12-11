package ui.transition;

import javafx.animation.ScaleTransition;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import ui.components.SVGViewBase;

import java.io.IOException;
import java.nio.file.Path;

public class PopTransitionController {

    private final ScaleTransition scaleTransition;
    private Media clickSound;
    public PopTransitionController(SVGViewBase n) {
        scaleTransition = new ScaleTransition();
        scaleTransition.setNode(n);
        scaleTransition.setCycleCount(1);
        scaleTransition.setDuration(Duration.millis(200));

        scaleTransition.setFromX(1.2);
        scaleTransition.setToX(1);

        scaleTransition.setFromY(1.2);
        scaleTransition.setToY(1);
//        try{
//            clickSound = new Media(ClassLoader.getSystemResources("assets/audio/ClickButton.mp3").toString());
//        }catch (Exception e){
//            System.out.println("Can't load sound");
//            e.printStackTrace();
//        }
    }

    public void playAnimation(){
        this.scaleTransition.playFromStart();
    }

    public void playSound(){
//        new MediaPlayer(this.clickSound).play();
    }
}
