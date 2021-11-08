package com.dofasu.javamon.controller;

import com.dofasu.javamon.models.Attack;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.view.BattleView;
import com.dofasu.javamon.view.EndView;
import com.dofasu.javamon.view.components.Combatant;
import com.dofasu.javamon.view.components.MessageBox;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

public class Controller {

    enum BattleStatus {
        PLAYER_ATTACK_START, PLAYER_ATTACK_END, OPPONENT_ATTACK_START, OPPONENT_ATTACK_END
    }

    private static final Controller instance = new Controller();

    // Prevent instantiation (uses Singleton pattern)
    private Controller() {
        buildJavamonList();
    }

    public static Controller getInstance() {
        return instance;
    }

    // Fields
    private List<Javamon> javamonList;
    private Javamon player, opponent;
    private Combatant playerCombatant, opponentCombatant;
    private Scene scene;
    private MessageBox messageBox;
    private BattleStatus status = BattleStatus.OPPONENT_ATTACK_END;
    private Attack nextAttack;

    public List<Javamon> getJavamonList() {
        return javamonList;
    }

    public void startBattle(Scene scene, Javamon player) {
        this.player = player;

        // TODO: Select opponent Javamon randomly instead of hardcoding. Consider disallowing same Javamon as player
        this.opponent = getJavamonList().get(1);

        goTo(scene, new BattleView(scene));
    }

    public void doAttack(Attack attack, Javamon target, Combatant combatant) {
        double damage = calculateDamage(attack, target);
        target.decreaseHealth(damage);
        combatant.updateHealthBar();
        checkGameOver();
    }

    public void next(Attack attack) {
        switch (status) {
            case OPPONENT_ATTACK_END:
                messageBox.updateMessage(player.getName() + " used " + attack.getName());
                status = BattleStatus.PLAYER_ATTACK_START;
                messageBox.disableButton(false);
                playerCombatant.disableAttackButtons(true);
                nextAttack = attack;
                break;
            case PLAYER_ATTACK_START:
                if (didHit(nextAttack)) {
                    doAttack(nextAttack, opponent, opponentCombatant);
                    messageBox.updateMessage(getEffectivenessString(attack, opponent));
                } else {
                    messageBox.updateMessage(player.getName() + " missed");
                }
                status = BattleStatus.PLAYER_ATTACK_END;
                messageBox.disableButton(false);
                playerCombatant.disableAttackButtons(true);
                break;
            case PLAYER_ATTACK_END:
                playerCombatant.disableAttackButtons(true);
                nextAttack = getRandomAttack(opponent);
                messageBox.updateMessage(opponent.getName() + " used " + nextAttack.getName());
                status = BattleStatus.OPPONENT_ATTACK_START;
                messageBox.disableButton(false);
                break;
            case OPPONENT_ATTACK_START:
                if (didHit(nextAttack)) {
                    doAttack(nextAttack, player, playerCombatant);
                    messageBox.updateMessage(getEffectivenessString(attack, player));
                } else {
                    messageBox.updateMessage(opponent.getName() + " missed");
                }

                messageBox.disableButton(true);
                playerCombatant.disableAttackButtons(false);
                status = BattleStatus.OPPONENT_ATTACK_END;
                break;
            default:
                messageBox.updateMessage("No current status");
        }
    }

    private Attack getRandomAttack(Javamon attacker) {
        int attackIndex = getRandomNumberBetween(0, 3);
        return attacker.getAttacks().get(attackIndex);
    }

    private double calculateDamage(Attack attack, Javamon javamon) {
        double effectiveness = javamon.getType().getEffectiveness(attack.getType());
        return attack.getStrength() * effectiveness * 0.2;
    }

    private String getEffectivenessString(Attack attack, Javamon javamon) {
        // TODO: Need a method to get the actual string
        return "It's super effective (not really)!";
    }

    private void checkGameOver() {
        if (opponent.getHealth() <= 0 || player.getHealth() <= 0) {
            goTo(scene, new EndView());
            status = BattleStatus.OPPONENT_ATTACK_END;
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

    public Javamon getPlayer() {
        return player;
    }
}
