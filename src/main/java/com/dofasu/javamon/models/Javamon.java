package com.dofasu.javamon.models;

import com.dofasu.javamon.actions.Attack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Javamon {
    private String name;
    private List<Attack> attackList;
    private double health = 100.0;
    private String imageUrl;
    private ElementType type;

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Attack> getAttacks() {
        return attackList;
    }

    public void setAttackList(List<Attack> attackList) {
        this.attackList = attackList;
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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void doAttack() {

    }

    public void decreaseHealth(double damage) {
        double newHealth = getHealth() - damage;
        if (newHealth < 0) newHealth = 0;
        setHealth(newHealth);
    }

    public double getEffectiveness() {
        Map<ElementType, List<ElementType>> effectiveAgainstFire = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstWater = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstGrass = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstElectric = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstRock = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstNormal = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstFlying = new HashMap<>();
        Map<ElementType, List<ElementType>> effectiveAgainstGround = new HashMap<>();

        return 0;
    }
}