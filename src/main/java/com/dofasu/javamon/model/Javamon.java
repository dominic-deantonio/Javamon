package com.dofasu.javamon.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Javamon {
    private final String name, imageUrl;
    private final List<Attack> attackList;
    private final ElementType type;
    private double health = 100.0;

    public ElementType getType() {
        return type;
    }

    public Javamon(String name, List<Attack> attackList, String imageUrl, ElementType type) {
        this.name = name;
        this.attackList = attackList;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public List<Attack> getAttacks() {
        return attackList;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void decreaseHealth(double damage) {
        double newHealth = getHealth() - damage;
        if (newHealth < 0) newHealth = 0;
        setHealth(newHealth);
    }

    public static List<Javamon> buildList() {
        List<Javamon> list = new ArrayList<>();

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

        list.add(pikachu);
        list.add(charmander);
        list.add(squirtle);
        list.add(bulbasaur);
        list.add(geodude);
        list.add(pidgeotto);
        list.add(snorlax);

        return list;

    }
}