package com.dofasu.javamon.controller;

import com.dofasu.javamon.actions.Attack;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.models.AttackType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Controller {
    public static void startGame() {
        System.out.println("Started game");
    }

    public Collection<Javamon> buildJavamon(){

        Collection<Javamon> javamonList = new ArrayList<>();

        List<Attack> pikachuAttacks = Arrays.asList(
                new Attack("Thunderbolt", AttackType.ELECTRIC, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Scratch", AttackType.NORMAL,50,80),
                new Attack("Sand Attack", AttackType.GROUND, 60, 80));
        Javamon pikachu = new Javamon("Pikachu", pikachuAttacks, 100, "pikachu.png");

        List<Attack> charmanderAttacks = Arrays.asList(
                new Attack("Flamethrower", AttackType.FIRE, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Scratch", AttackType.NORMAL,50,80),
                new Attack("Sand Attack", AttackType.GROUND, 60, 80));
        Javamon charmander = new Javamon("Charmander", charmanderAttacks, 100, "charmander.png");

        List<Attack> squirtleAttacks = Arrays.asList(
                new Attack("Water gun", AttackType.WATER, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Scratch", AttackType.NORMAL,50,80),
                new Attack("Sand Attack", AttackType.GROUND, 60, 80));
        Javamon squirtle = new Javamon("Squirtle", squirtleAttacks, 100, "squirtle.png");

        List<Attack> bulbasaurAttacks = Arrays.asList(
                new Attack("Leaf Blade", AttackType.WATER, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Bite", AttackType.NORMAL,50,80),
                new Attack("Sand Attack", AttackType.GROUND, 60, 80));
        Javamon bulbasaur = new Javamon("Bulbasaur", bulbasaurAttacks, 100, "bulbasaur.png");

        List<Attack> geodudeAttacks = Arrays.asList(
                new Attack("Rock Throw", AttackType.ROCK, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Punch", AttackType.NORMAL,50,80),
                new Attack("Sand Attack", AttackType.GROUND, 60, 80));
        Javamon geodude = new Javamon("Geodude", geodudeAttacks, 100, "geodude.png");

        List<Attack> pidgeottoAttacks = Arrays.asList(
                new Attack("Air Slash", AttackType.FLYING, 80, 80),
                new Attack("Tackle", AttackType.NORMAL, 60, 80),
                new Attack("Scratch", AttackType.NORMAL,50,80),
                new Attack("Gust", AttackType.FLYING, 60, 80));
        Javamon pidgeotto = new Javamon("Pidgeotto", pidgeottoAttacks, 100, "pidgeotto.png");

        List<Attack> snorlaxAttacks = Arrays.asList(
                new Attack("Earthquake", AttackType.GROUND, 80, 80),
                new Attack("Body Slam", AttackType.NORMAL, 60, 80),
                new Attack("Punch", AttackType.NORMAL,50,80),
                new Attack("Roll", AttackType.NORMAL, 60, 80));
        Javamon snorlax = new Javamon("Snorlax", snorlaxAttacks, 100, "snorlax.png");

        javamonList.add(pikachu);
        javamonList.add(charmander);
        javamonList.add(squirtle);
        javamonList.add(bulbasaur);
        javamonList.add(geodude);
        javamonList.add(pidgeotto);
        javamonList.add(snorlax);

        return javamonList;
    }
}
