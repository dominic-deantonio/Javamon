package com.dofasu.javamon.view.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bar extends Rectangle {
    public Bar(double width, Color color) {
        super(width, 20, color);
        setHeight(20);
        setArcWidth(10.0);
        setArcHeight(10.0);
    }
}
