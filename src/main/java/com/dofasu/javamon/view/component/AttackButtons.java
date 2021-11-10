package com.dofasu.javamon.view.component;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.model.Attack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AttackButtons creates the attack buttons for the player
 * @author DOFASU
 * @version 1.0
 */

public class AttackButtons extends VBox {

    private Controller controller = Controller.getInstance();
    private Collection<AttackButton> buttons = new ArrayList<>();

    /**
     * Registers the functionality of the buttons for attack. If the player clicks on the four
     * attack options, the Javamon will attack using the chosen attack.
     * @param attacks the list of attacks available to select.
     */

    public AttackButtons(List<Attack> attacks) {
        int index = 0;
        for (int x = 0; x < 2; x++) {
            HBox row = new HBox();
            for (int y = 0; y < 2; y++) {
                Attack attack = attacks.get(index);
                AttackButton button = new AttackButton(attack, (e) -> {
                    controller.nextStep(attack);
                });
                buttons.add(button);
                row.getChildren().add(button);
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
            setPrefWidth(200);
            setPrefHeight(40);
            setStyle(getColor());
            setOnAction(eventHandler);
        }
    }
}
