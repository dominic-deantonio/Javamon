package com.dofasu.javamon.model;

public class Attack {

    private final String name;
    private final ElementType type;
    private final double strength;
    private final double accuracy;

    public Attack(String name, ElementType type, double strength, double accuracy) {
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public ElementType getType() {
        return type;
    }

    public double getStrength() {
        return strength;
    }

    public double getAccuracy() {
        return accuracy;
    }

}