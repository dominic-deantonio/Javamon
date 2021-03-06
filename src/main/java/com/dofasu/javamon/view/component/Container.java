package com.dofasu.javamon.view.component;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Container is used to contain the information that is outputed in the GUI.
 * The information is compacted into a box that is shown on the screen
 * @author DOFASU
 * @version 1.0
 */

public class Container extends StackPane {

    private Rectangle rect;

    public Container(double width, double height, Node child, double opacity){
        super();
        rect = new Rectangle(width, height, Color.BLACK);
        rect.setOpacity(opacity);
        rect.setArcWidth(10.0);
        rect.setArcHeight(10.0);

        getChildren().addAll(rect, child);
    }
}
