package com.dofasu.javamon.view.component;

import com.dofasu.javamon.model.ElementType;

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
