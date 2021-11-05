package com.dofasu.javamon.models;

import com.dofasu.javamon.actions.Attack;

import java.util.List;

public class Javamon {
    public String name;
    public List<Attack> attackList;
    public double health = 100.0;
    public String imageUrl;
    public ElementType element;

    public ElementType getElement() {
        return element;
    }

    public void setElement(ElementType element) {
        this.element = element;
    }

    public Javamon(String name, List<Attack> attackList, String imageUrl) {
        this.name = name;
        this.attackList = attackList;
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

    public void doAttack() {

    }

    public void decreaseHealth(double damage, double health) {

    }

    public void fainted() {
        if (this.health <= 0) {
            System.out.println("Your Javamon has fainted");
        }
    }


}