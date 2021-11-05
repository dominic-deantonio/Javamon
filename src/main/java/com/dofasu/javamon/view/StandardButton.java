package com.dofasu.javamon.view;

import com.dofasu.javamon.models.Constants;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;

public class StandardButton extends Button {
    StandardButton(String label, EventHandler<ActionEvent> eventHandler) {
        super(label);
        setStyle(Constants.BUTTON_COLOR);
        setPrefWidth(200);
        setTextFill(Color.WHITE);
        setOnAction(eventHandler);
    }
}
