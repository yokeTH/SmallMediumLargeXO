package ui;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import ui.scene.Menu;

public class Main extends Application {
    public static Stage stage;
    public static AudioClip audioClip;
    @Override
    public void start(Stage stage) {
        audioClip = new AudioClip(ClassLoader.getSystemResource("assets/audio/BackgroundMusic.m4a").toString());
        audioClip.play();
        Main.stage = stage;

        stage.setResizable(false);
        stage.setTitle("XO Game");
        stage.setScene(Menu.getSceneInstance());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
