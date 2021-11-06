package com.dofasu.javamon.controller;

import com.dofasu.javamon.actions.Attack;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.models.ElementType;
import com.dofasu.javamon.view.BattleView;
import com.dofasu.javamon.view.EndView;
import com.dofasu.javamon.view.components.Combatant;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private static final Controller instance = new Controller();

    // Prevent instantiation (uses Singleton pattern)
    private Controller() {
        buildJavamon();
    }

    public static Controller getInstance() {
        return instance;
    }

    // Fields
    private List<Javamon> javamonList;
    private Javamon player, opponent;
    private Combatant playerCombatant, opponentCombatant;
    private Scene scene;

    public void buildJavamon() {

        List<Javamon> javamonList = new ArrayList<>();

        List<Attack> pikachuAttacks = Arrays.asList(
                new Attack("Thunderbolt", ElementType.ELECTRIC, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL, 50, 80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon pikachu = new Javamon("Pikachu", pikachuAttacks, "/pikachu.png", ElementType.ELECTRIC);

        List<Attack> charmanderAttacks = Arrays.asList(
                new Attack("Flamethrower", ElementType.FIRE, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL, 50, 80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon charmander = new Javamon("Charmander", charmanderAttacks, "/charmander.png", ElementType.FIRE);

        List<Attack> squirtleAttacks = Arrays.asList(
                new Attack("Water gun", ElementType.WATER, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL, 50, 80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon squirtle = new Javamon("Squirtle", squirtleAttacks, "/squirtle.png", ElementType.WATER);

        List<Attack> bulbasaurAttacks = Arrays.asList(
                new Attack("Leaf Blade", ElementType.GRASS, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Bite", ElementType.NORMAL, 50, 80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon bulbasaur = new Javamon("Bulbasaur", bulbasaurAttacks, "/bulbasaur.png", ElementType.GRASS);

        List<Attack> geodudeAttacks = Arrays.asList(
                new Attack("Rock Throw", ElementType.ROCK, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Punch", ElementType.NORMAL, 50, 80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon geodude = new Javamon("Geodude", geodudeAttacks, "/geodude.png", ElementType.ROCK);

        List<Attack> pidgeottoAttacks = Arrays.asList(
                new Attack("Air Slash", ElementType.FLYING, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL, 50, 80),
                new Attack("Gust", ElementType.FLYING, 60, 80));
        Javamon pidgeotto = new Javamon("Pidgeotto", pidgeottoAttacks, "/pidgeotto.png", ElementType.FLYING);

        List<Attack> snorlaxAttacks = Arrays.asList(
                new Attack("Earthquake", ElementType.GROUND, 80, 80),
                new Attack("Body Slam", ElementType.NORMAL, 60, 80),
                new Attack("Punch", ElementType.NORMAL, 50, 80),
                new Attack("Roll", ElementType.NORMAL, 60, 80));
        Javamon snorlax = new Javamon("Snorlax", snorlaxAttacks, "/snorlax.png", ElementType.NORMAL);

        javamonList.add(pikachu);
        javamonList.add(charmander);
        javamonList.add(squirtle);
        javamonList.add(bulbasaur);
        javamonList.add(geodude);
        javamonList.add(pidgeotto);
        javamonList.add(snorlax);

        this.javamonList = javamonList;
    }

    public List<Javamon> getJavamonList() {
        return javamonList;
    }

    public void startBattle(Scene scene, Javamon player) {
        this.player = player;

        // TODO: Select opponent Javamon randomly instead of hardcoding. Consider disallowing same Javamon as player
        this.opponent = getJavamonList().get(1);

        new Navigator().goTo(scene, new BattleView(scene));
    }

    public Javamon getOpponent() {
        return this.opponent;
    }

    public Javamon getPlayer() {
        return player;
    }

    // This is called by the GUI attack buttons
    public void attackOpponent(Attack attack) {
        // TODO: Create a better attack algorithm
        opponent.decreaseHealth(attack.getStrength());
        opponentCombatant.updateHealthBar();
        checkGameOver();
    }

    private void attackPlayer(Attack attack){
        // TODO: have AI attack the player and update the UI
    }

    // This is called after an attack and the GUI is updated to show the attack results
    private void checkGameOver() {
        if (opponent.getHealth() <= 0 || player.getHealth() <= 0)
            new Navigator().goTo(scene, new EndView());
    }

    public void setCombatants(Combatant player, Combatant opponent, Scene scene) {
        this.playerCombatant = player;
        this.opponentCombatant = opponent;
        this.scene = scene;
    }
}
