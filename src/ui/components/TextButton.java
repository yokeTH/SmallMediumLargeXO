package ui.components;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextButton extends Button {
    public TextButton(String text){
        super(text);
        this.setCursor(Cursor.HAND);
        this.setMinWidth(256);
        this.setMaxWidth(256);
        this.setStyle(
                "-fx-background-color: #3498db; " +
                        "-fx-background-radius: 5px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-font-size: 18px; " +
                        "-fx-text-fill: #ffffff;" +
                        "-fx-font-family: 'Itim';"
        );

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setRadius(5);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        this.setEffect(dropShadow);

        this.setOnMouseEntered(e -> {
            this.setStyle(
                    "-fx-background-color: #2980b9; " +
                            "-fx-background-radius: 5px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-font-size: 18px; " +
                            "-fx-text-fill: #ffffff;" +
                            "-fx-font-family: 'Itim';"
            );
        });

        this.setOnMouseExited(e -> {
            this.setStyle(
                    "-fx-background-color: #3498db; " +
                            "-fx-background-radius: 5px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-font-size: 18px; " +
                            "-fx-text-fill: #ffffff;" +
                            "-fx-font-family: 'Itim';"
            );
        });
    }
}
