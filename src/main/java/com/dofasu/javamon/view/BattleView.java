package com.dofasu.javamon.view;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.view.components.AttackButtons;
import com.dofasu.javamon.view.components.Combatant;
import com.dofasu.javamon.view.components.HealthBar;
import com.dofasu.javamon.view.components.ElementTypeButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BattleView extends VBox {

    Controller controller = Controller.getInstance();
    Combatant player;
    Combatant opponent;

    public BattleView(Scene scene) {
        super(5);
        setStyle("-fx-font-family: 'sans-serif'");

        player = new Combatant(controller.getPlayer(), true);
        opponent = new Combatant(controller.getOpponent(), false);
        controller.setCombatants(player, opponent, scene);

        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(
                opponent,
                new Text("\n\n\n\n"),
                player,
                new Text("\n")
        );
    }
}
