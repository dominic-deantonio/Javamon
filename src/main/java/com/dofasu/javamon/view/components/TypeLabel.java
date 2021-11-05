package com.dofasu.javamon.view.components;

import com.dofasu.javamon.models.Constants;
import com.dofasu.javamon.models.ElementType;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class TypeLabel extends Button {

    ElementType type;

    public TypeLabel(ElementType type) {
        super(type.name());
        this.type = type;
        setStyle(getColor());
        setPrefWidth(100);
        setTextFill(Color.WHITE);
        setFocused(false);
        setFocusTraversable(false);
    }

    private String getColor() {
        return "-fx-base: " + type.getHexColor();
    }

    public void updateType(ElementType type) {
        this.type = type;
        setStyle(getColor());
        setText(type.name());
    }

}
