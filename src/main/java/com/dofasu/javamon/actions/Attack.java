package com.dofasu.javamon.actions;

import com.dofasu.javamon.models.Javamon;

import java.lang.reflect.Type;

public class Attack {

    public String name;
    public Type type;
    public double strength;
    public double accuracy;

    public Attack(String name, Type type, double strength, double accuracy) {
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void attack(Javamon javamon){

    }
}