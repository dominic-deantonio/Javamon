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
        setBackground(getBackgroundImage());
    }

    // TODO move this method into controller?
    private Background getBackgroundImage() {
        Image image = new Image("/background3.png", true);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
        return new Background(bgImage);
    }
}
