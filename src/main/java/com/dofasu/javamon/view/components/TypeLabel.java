package com.dofasu.javamon.view.components;

import com.dofasu.javamon.models.Constants;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class TypeLabel extends Button {

    public TypeLabel() {
        super("Electric");
        setStyle(Constants.BUTTON_YELLOW);
        setPrefWidth(100);
        setTextFill(Color.WHITE);
//        setDisable(true);
    }

}
