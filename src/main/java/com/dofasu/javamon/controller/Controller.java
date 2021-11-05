package com.dofasu.javamon.controller;

import com.dofasu.javamon.actions.Attack;
import com.dofasu.javamon.models.Javamon;
import com.dofasu.javamon.models.ElementType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Controller {
    public static void startGame() {
        System.out.println("Started game");
    }

    public Collection<Javamon> buildJavamon(){
        double health = 100;

        Collection<Javamon> javamonList = new ArrayList<>();

        List<Attack> pikachuAttacks = Arrays.asList(
                new Attack("Thunderbolt", ElementType.ELECTRIC, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL,50,80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon pikachu = new Javamon("Pikachu", pikachuAttacks, health, "/pikachu.png");

        List<Attack> charmanderAttacks = Arrays.asList(
                new Attack("Flamethrower", ElementType.FIRE, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL,50,80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon charmander = new Javamon("Charmander", charmanderAttacks, health, "/charmander.png");

        List<Attack> squirtleAttacks = Arrays.asList(
                new Attack("Water gun", ElementType.WATER, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL,50,80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon squirtle = new Javamon("Squirtle", squirtleAttacks, health, "/squirtle.png");

        List<Attack> bulbasaurAttacks = Arrays.asList(
                new Attack("Leaf Blade", ElementType.WATER, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Bite", ElementType.NORMAL,50,80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon bulbasaur = new Javamon("Bulbasaur", bulbasaurAttacks, health, "/bulbasaur.png");

        List<Attack> geodudeAttacks = Arrays.asList(
                new Attack("Rock Throw", ElementType.ROCK, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Punch", ElementType.NORMAL,50,80),
                new Attack("Sand Attack", ElementType.GROUND, 60, 80));
        Javamon geodude = new Javamon("Geodude", geodudeAttacks, health, "/geodude.png");

        List<Attack> pidgeottoAttacks = Arrays.asList(
                new Attack("Air Slash", ElementType.FLYING, 80, 80),
                new Attack("Tackle", ElementType.NORMAL, 60, 80),
                new Attack("Scratch", ElementType.NORMAL,50,80),
                new Attack("Gust", ElementType.FLYING, 60, 80));
        Javamon pidgeotto = new Javamon("Pidgeotto", pidgeottoAttacks, health, "/pidgeotto.png");

        List<Attack> snorlaxAttacks = Arrays.asList(
                new Attack("Earthquake", ElementType.GROUND, 80, 80),
                new Attack("Body Slam", ElementType.NORMAL, 60, 80),
                new Attack("Punch", ElementType.NORMAL,50,80),
                new Attack("Roll", ElementType.NORMAL, 60, 80));
        Javamon snorlax = new Javamon("Snorlax", snorlaxAttacks, health, "/snorlax.png");

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
