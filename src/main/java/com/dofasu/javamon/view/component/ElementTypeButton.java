package com.dofasu.javamon.view.component;

import com.dofasu.javamon.model.ElementType;

/**
 * ElementTypeButton is used to represent the element - Fire, Water, Grass, etc...
 * This representation has no function other than to show the Javamon's type.
 * @author DOFASU
 * @version 1.0
 */

public class ElementTypeButton extends ElementButton {

    /**
     * Sets the type of element to the selected element
     * @param type is the type of element - Fire, Water, Ground, etc... in ElementType
     */

    public ElementTypeButton(ElementType type) {
        super(type, type.name());
        setStyle(getColor());
        setPrefWidth(100);
    }

    /**
     * Updates the type of element to the selected element
     * @param type is the type of element - Fire, Water, Ground, etc... in ElementType
     */
    public void updateType(ElementType type) {
        this.type = type;
        setStyle(getColor());
        setText(type.name());
    }

}
