package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.view.components.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class BattleView extends VBox {

    Controller controller = Controller.getInstance();
    Combatant player;
    Combatant opponent;
    MessageBox messageBox = new MessageBox();

    public BattleView(Scene scene) {
        super(5);
        setStyle("-fx-font-family: 'sans-serif'");

        player = new Combatant(controller.getPlayer(), true);
        opponent = new Combatant(controller.getOpponent(), false);
        controller.setBattle(player, opponent, scene, messageBox); // TODO refactor to 'setBattle' and pass in the messageBox

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
