package com.dofasu.javamon.view.components;

import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.models.Javamon;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Combatant extends HBox {

    private final Javamon javamon;
    private final HealthBar healthBar = new HealthBar();
    private final AttackButtons attackButtons;

    public Combatant(Javamon javamon, boolean isPlayer) {
        super();
        this.javamon = javamon;
        final CombatantInfo info = new CombatantInfo();
        ImageView image = Images.getImageView(javamon.getImageUrl());
        attackButtons = new AttackButtons(javamon.getAttacks());
        if (isPlayer) {
            image.setScaleX(-1);
            VBox playerGui = new VBox(info, attackButtons);
            playerGui.setSpacing(10);
            getChildren().addAll(image, playerGui);
        } else {
            getChildren().addAll(info, image);
        }
        setSpacing(150);
    }

    class CombatantInfo extends VBox {

        CombatantInfo() {
            super();
            Text nameLabel = new Text(javamon.getName());
            nameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            nameLabel.setFill(Color.WHITE);
            VBox column = new VBox(new Text("\n"), nameLabel, healthBar, new ElementTypeButton(javamon.getType()), new Text("\n"));
            HBox row = new HBox(new Text("   "), column);
            Container container = new Container(400, 100, row, .6);
            getChildren().add(container);
        }
    }

    public void updateHealthBar() {
        healthBar.setHp(javamon.getHealth());
    }

    public void disableAttackButtons(boolean isDisabled) {
        attackButtons.setDisable(isDisabled);
    }
}