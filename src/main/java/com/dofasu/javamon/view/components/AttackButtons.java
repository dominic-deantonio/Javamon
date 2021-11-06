package com.dofasu.javamon.view.components;

import com.dofasu.javamon.actions.Attack;
import com.dofasu.javamon.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class AttackButtons extends VBox {

    Controller controller = Controller.getInstance();

    public AttackButtons(List<Attack> attacks) {
        int index = 0;
        for (int x = 0; x < 2; x++) {
            HBox row = new HBox();
            for (int y = 0; y < 2; y++) {
                Attack attack = attacks.get(index);
                row.getChildren().add(new AttackButton(attack, (e) -> {
                    controller.attackOpponent(attack);
                }));
                index++;
            }
            row.setSpacing(5);
            getChildren().add(row);
        }
        setSpacing(5);
    }

    private class AttackButton extends ElementButton {
        public AttackButton(Attack attack, EventHandler<ActionEvent> eventHandler) {
            super(attack.getType(), attack.getName());
            setPrefWidth(190);
            setPrefHeight(40);
            setStyle(getColor());
            setOnAction(eventHandler);
        }
    }
}
