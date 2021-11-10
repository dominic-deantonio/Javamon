package com.dofasu.javamon.view.component;

import com.dofasu.javamon.controller.Controller;
import com.dofasu.javamon.model.Javamon;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Combatant creates the combatants in the game - the player's Javamon and the opponent's Javamon
 * @author DOFASU
 * @version 1.0
 */

public class Combatant extends HBox {

    private final Javamon javamon;
    private final HealthBar healthBar = new HealthBar();
    private final AttackButtons attackButtons;

    /**
     * Creates the Javamon avatar and placement in the battle scene
     * @param javamon provides the image of the javamon
     * @param isPlayer if the Javamon belongs to the player, then the Javamon will be flipped 180 degrees
     *                 in the battle scene
     */

    public Combatant(Javamon javamon, boolean isPlayer) {
        super();
        this.javamon = javamon;
        final CombatantInfo info = new CombatantInfo();
        ImageView image = Controller.getInstance().getImageView(javamon.getImageUrl());
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

    /**
     * CombatantInfo contains the information of the Javamon
     * @author DOFASU
     * @version 1.0
     */

    class CombatantInfo extends VBox {

        /**
         * Creates the information of the Javamon to include the name, type, and how much HP
         * the Javamon has.
         */

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

    /**
     * Updates the health bar of the javamons
     */

    public void updateHealthBar() {
        healthBar.setHp(javamon.getHealth());
    }

    /**
     * Disables the attack button choices
     */

    public void disableAttackButtons(boolean isDisabled) {
        attackButtons.setDisable(isDisabled);
    }
}