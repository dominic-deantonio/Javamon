package com.dofasu.javamon.view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HealthBar extends HBox {

    int currentHp = 100;
    final double maxHp = 100;
    Text hpLabel = new Text("100 HP");
    StackedBar bar = new StackedBar();

    public HealthBar() {
        hpLabel.setFont(Font.font("Monospace", FontWeight.BOLD, 20));
        hpLabel.setFill(Color.WHITE);
        getChildren().addAll(bar, hpLabel);
        setSpacing(10);
    }

    private class StackedBar extends StackPane {
        private final double maxWidth = 300;
        Bar backBar = new Bar(maxWidth, Color.LIGHTGREY);
        Bar frontBar = new Bar(maxWidth, Color.GREEN);

        private StackedBar() {
            super();
            getChildren().addAll(backBar, frontBar);
            setAlignment(Pos.CENTER_LEFT);
        }

        // Expects a value from 0 - 100
        private void updateFrontBar() {
            // Need to translate amount from 100 base to 300 base
            double guiHealthLevel = (currentHp / maxHp) * maxWidth;
            Color hpColor = getColor(currentHp);
            frontBar.setWidth(guiHealthLevel);
            frontBar.setFill(hpColor);
        }

        private Color getColor(double health) {
            if (health < 33) {
                return Color.TOMATO;
            } else if (health < 66) {
                return Color.ORANGE;
            } else {
                return Color.GREEN;
            }
        }
    }

    private class Bar extends Rectangle {
        private Bar(double width, Color color) {
            super(width, 20, color);
            setHeight(20);
            setArcWidth(10.0);
            setArcHeight(10.0);
        }
    }

    public void setHp(double newHealth) {
        currentHp = (int) newHealth;
        // Without padding, the image jumps around when the HP amount changes
        String digitPadding = currentHp < 10 ? "  " : currentHp < 100 ? " " : "";

        hpLabel.setText(digitPadding + currentHp + " HP");
        bar.updateFrontBar();
    }
}
