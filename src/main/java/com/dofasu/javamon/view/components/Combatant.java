package com.dofasu.javamon.view.components;

import com.dofasu.javamon.controller.Images;
import com.dofasu.javamon.models.Javamon;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Combatant extends HBox {

    private final Javamon javamon;
    private final HealthBar healthBar = new HealthBar();

    public Combatant(Javamon javamon, boolean isPlayer) {
        super();
        this.javamon = javamon;
        final CombatantInfo info = new CombatantInfo();
        ImageView image = Images.getImageView(javamon.getImageUrl());
        if (isPlayer) {
            image.setScaleX(-1);
            VBox playerGui = new VBox(info, new AttackButtons(javamon.getAttacks()));
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
            getChildren().addAll(
                    new Text("\n"),
                    nameLabel,
                    healthBar,
                    new ElementTypeButton(javamon.getType())
            );
        }
    }

    public void updateHealthBar() {
        healthBar.setHp(javamon.getHealth());
    }
}