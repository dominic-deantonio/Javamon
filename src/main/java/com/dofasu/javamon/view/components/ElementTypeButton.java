package com.dofasu.javamon.view.components;

import com.dofasu.javamon.models.Constants;
import com.dofasu.javamon.models.ElementType;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ElementTypeButton extends ElementButton {

    public ElementTypeButton(ElementType type) {
        super(type, type.name());
        setStyle(getColor());
        setPrefWidth(100);
    }

    public void updateType(ElementType type) {
        this.type = type;
        setStyle(getColor());
        setText(type.name());
    }

}
