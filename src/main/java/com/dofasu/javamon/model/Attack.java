package com.dofasu.javamon.model;

/**
 * Attack Class manages the attack parameters
 * @author DOFASU
 * @version 1.0
 * @see com.dofasu.javamon.model.Javamon
 */


public class Attack {

    private final String name;
    private final ElementType type;
    private final double strength;
    private final double accuracy;

    /**
     * Provides the attributes for Attack
     */

    public Attack(String name, ElementType type, double strength, double accuracy) {
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.accuracy = accuracy;
    }

    /**
     * @return the name of the attack in a String
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type of the attack - Fire, Water, Ground, Grass, etc...
     */
    public ElementType getType() {
        return type;
    }

    /**
     * @return the strength in the form of a double value. The strength is how much damage the attack will do
     */
    public double getStrength() {
        return strength;
    }

    /**
     * @return the accuracy of the attack. The accuracy is the likelihood of the attack being successful.
     */
    public double getAccuracy() {
        return accuracy;
    }

}