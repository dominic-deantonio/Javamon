package com.dofasu.javamon.view.component;

import com.dofasu.javamon.model.ElementType;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

abstract class ElementButton extends Button {
    ElementType type;

    public ElementButton(ElementType type, String label) {
        super(label);
        this.type = type;
        setFocused(false);
        setFocusTraversable(false);
        setTextFill(Color.WHITE);
    }

    protected String getColor() {
        return "-fx-base: " + type.getHexColor();
    }

}
