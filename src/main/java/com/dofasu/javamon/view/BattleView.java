package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.view.component.Combatant;
import com.dofasu.javamon.view.component.MessageBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * BattleView creates the battle setting for the player's Javamon
 * the opponent's Javamon
 * @author DOFASU
 * @version 1.0
 */

public class BattleView extends VBox {

    Controller controller = Controller.getInstance();
    Combatant player;
    Combatant opponent;
    MessageBox messageBox = new MessageBox();


    /**
     * Registers the GUI to display the battle background. The background displays a forest and grass.
     * The opponent is on the top right hand corner and the player is on the bottom right hand corner.
     * Clicking on the buttons allows the player to choose
     * their attacks. After selecting the attack, the player will click on the next button
     * and wait for the opponent to make their move.
     * @param scene the background to display.
     */

    public BattleView(Scene scene) {
        super(5);
        setStyle("-fx-font-family: 'sans-serif'");

        player = new Combatant(controller.getPlayer(), true);
        opponent = new Combatant(controller.getOpponent(), false);
        controller.setBattle(player, opponent, scene, messageBox);

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                opponent,
                new Text("\n\n\n\n"),
                player,
                messageBox
        );
        setBackground(controller.getBackgroundImage("/background3.png"));
    }
}
