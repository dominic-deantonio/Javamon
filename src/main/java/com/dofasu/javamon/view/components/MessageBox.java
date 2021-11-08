package com.dofasu.javamon.view.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MessageBox extends StackPane {

    private final Text messageText = new Text("Select an attack");

    public MessageBox() {
        Rectangle box = new Rectangle(800, 100, Color.WHITESMOKE);
        box.setArcWidth(10.0);
        box.setArcHeight(10.0);
        box.setStrokeWidth(2);
        box.setStroke(Color.BLACK);
        getChildren().addAll(box, messageText);
    }

    public void updateMessage(String message) {
        messageText.setText(message);
    }
}
