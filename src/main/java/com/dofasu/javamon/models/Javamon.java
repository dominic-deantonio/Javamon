package com.dofasu.javamon.models;

import com.dofasu.javamon.actions.Attack;

import java.util.List;

public class Javamon {
    public String name;
    public List<Attack> attackList;
    public double health;
    public String imageUrl;

    public Javamon(String name, List<Attack> attackList, double health, String imageUrl) {
        this.name = name;
        this.attackList = attackList;
        this.health = health;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attack> getAttackList() {
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

    public void doAttack(Javamon javamon, Attack attack){
        // javamon attacks

    }

    public void decreaseHealth (double damage, double health){
        // calls doAttack and checks damage

        // new health = old health - damage
    }

}