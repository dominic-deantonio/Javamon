package com.dofasu.javamon.controller;

import com.dofasu.javamon.model.Attack;
import com.dofasu.javamon.model.ElementType;
import com.dofasu.javamon.model.Javamon;
import com.dofasu.javamon.view.BattleView;
import com.dofasu.javamon.view.EndView;
import com.dofasu.javamon.view.component.Combatant;
import com.dofasu.javamon.view.component.MessageBox;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.Random;

/**
 * Main Controller class
 * @author DOFASU
 * @version 1.0
 */
public class Controller {

    enum BattleStatus {
        PLAYER_ATTACK_START, PLAYER_ATTACK_END, OPPONENT_ATTACK_START, OPPONENT_ATTACK_END, GAME_OVER
    }

    private static final Controller instance = new Controller();

    // Prevent instantiation (uses Singleton pattern)
    private Controller() {
        buildJavamonList();
    }

    // Fields
    private List<Javamon> javamonList;
    private Javamon player, opponent;
    private Combatant playerCombatant, opponentCombatant;
    private Scene scene;
    private MessageBox messageBox;
    private BattleStatus status = BattleStatus.OPPONENT_ATTACK_END;
    private Attack nextAttack;

    //returns list of Javamon

    public List<Javamon> getJavamonList() {
        return javamonList;
    }

    /**
     * Starts the battle
     * @param scene - content of Scene graph
     * @param player - current player
     */

    public void startBattle(Scene scene, Javamon player) {
        setPlayer(player);
        setOpponent(getRandomOpponent());
        goTo(scene, new BattleView(scene));
    }

    /**
     * selects random Javamon to battle with
     * @return random opponent other than the Javamon player selected
     */

    Javamon getRandomOpponent() {
        int maxIndex = getJavamonList().size() - 1;
        Javamon randomOpponent = getJavamonList().get(getRandomNumberBetween(0, maxIndex));
        while (randomOpponent.equals(getPlayer())) {
            randomOpponent = getJavamonList().get(getRandomNumberBetween(0, maxIndex));
        }
        return randomOpponent;
    }

    /**
     * Attacks the opponent
     * @see #nextStep(Attack)
     */

    public void doAttack(Attack attack, Javamon target, Combatant combatant) {
        double damage = calculateDamage(attack, target);
        target.decreaseHealth(damage);
        combatant.updateHealthBar();
    }

    /**
     * Both Javamon attacks each other one at a time
     * @param attack gets attack type to attack opponents
     */
    public void nextStep(Attack attack) {
        switch (status) {
            case OPPONENT_ATTACK_END:
                messageBox.updateMessage(getPlayer().getName() + " used " + attack.getName());
                status = BattleStatus.PLAYER_ATTACK_START;
                messageBox.disableButton(false);
                playerCombatant.disableAttackButtons(true);
                nextAttack = attack;
                break;
            case PLAYER_ATTACK_START:
                if (didHit(nextAttack)) {
                    doAttack(nextAttack, getOpponent(), opponentCombatant);
                    ElementType opponentType = getOpponent().getType();
                    String effectivenessString = opponentType.getEffectivenessString(nextAttack.getType());
                    messageBox.updateMessage(effectivenessString);
                } else {
                    messageBox.updateMessage(getPlayer().getName() + " missed");
                }
                status = BattleStatus.PLAYER_ATTACK_END;
                messageBox.disableButton(false);
                playerCombatant.disableAttackButtons(true);
                nextAttack = getRandomAttack(getOpponent());
                checkGameOver();
                break;
            case PLAYER_ATTACK_END:
                messageBox.updateMessage(getOpponent().getName() + " used " + nextAttack.getName());
                status = BattleStatus.OPPONENT_ATTACK_START;
                playerCombatant.disableAttackButtons(true);
                messageBox.disableButton(false);
                break;
            case OPPONENT_ATTACK_START:
                if (didHit(nextAttack)) {
                    doAttack(nextAttack, getPlayer(), playerCombatant);
                    ElementType playerType = getPlayer().getType();
                    String effectivenessString = playerType.getEffectivenessString(nextAttack.getType());
                    messageBox.updateMessage(effectivenessString);
                } else {
                    messageBox.updateMessage(getOpponent().getName() + " missed");
                }

                messageBox.disableButton(true);
                playerCombatant.disableAttackButtons(false);
                status = BattleStatus.OPPONENT_ATTACK_END;
                checkGameOver();
                break;
            case GAME_OVER:
                boolean userDidWin = getOpponent().equals(getLoser());
                goTo(scene, new EndView(userDidWin));
                status = BattleStatus.OPPONENT_ATTACK_END;
            default:
                messageBox.updateMessage("No current status");
        }
    }

    /**
     * Gets randomly selected attack based on Javamon type
     * @param attacker - javamon currently attacking
     * @return randomly selected attack
     */

    Attack getRandomAttack(Javamon attacker) {
        int attackIndex = getRandomNumberBetween(0, 3);
        return attacker.getAttacks().get(attackIndex);
    }

    /**
     * Calculates the damage
     * @param attack attack type
     * @param defender can be player or opponent currently defending
     * @return Total damage done in one attack
     */

    double calculateDamage(Attack attack, Javamon defender) {
        double effectiveness = defender.getType().getEffectiveness(attack.getType());
        return attack.getStrength() * effectiveness * 0.3;
    }

    private void checkGameOver() {
        Javamon loser = getLoser();
        if (loser != null) {
            messageBox.updateMessage(loser.getName() + " fainted!");
            status = BattleStatus.GAME_OVER;
            playerCombatant.disableAttackButtons(true);
            messageBox.disableButton(false);
        }
    }

    private Javamon getLoser() {
        if (getOpponent().getHealth() <= 0) {
            return getOpponent();
        } else if (getPlayer().getHealth() <= 0) {
            return getPlayer();
        } else {
            return null;
        }
    }

    public void setBattle(Combatant player, Combatant opponent, Scene scene, MessageBox messageBox) {
        this.playerCombatant = player;
        this.opponentCombatant = opponent;
        this.scene = scene;
        this.messageBox = messageBox;
    }

    private boolean didHit(Attack attack) {
        double acc = attack.getAccuracy();
        double hitChance = getRandomNumberBetween(0, 100);
        return hitChance < acc;
    }

    static int getRandomNumberBetween(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void buildJavamonList() {
        this.javamonList = Javamon.buildList();
    }

    public void goTo(Scene scene, Pane nextView) {
        scene.setRoot(nextView);
    }

    public Javamon getOpponent() {
        return this.opponent;
    }

    public void setOpponent(Javamon opponent) {
        this.opponent = opponent;
    }

    public Javamon getPlayer() {
        return player;
    }

    public void setPlayer(Javamon player) {
        this.player = player;
    }

    public static Controller getInstance() {
        return instance;
    }

    public Background getBackgroundImage(String path) {
        Image image = new Image(path, true);
        BackgroundSize size = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, size);
        return new Background(bgImage);
    }

    public ImageView getImageView(String path) {
        ImageView iv = new ImageView(path);
        iv.setPreserveRatio(true);
        iv.setFitHeight(250);
        return iv;
    }


    public Image getImage(String imageUrl) {
        return new Image(imageUrl);
    }
}
