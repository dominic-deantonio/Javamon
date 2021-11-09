package com.dofasu.javamon.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ElementType {
    FIRE, WATER, GRASS, ELECTRIC, GROUND, NORMAL, FLYING, ROCK;


    private static Map<ElementType, String> fxColors = buildColors();
    private static Map<ElementType, List<ElementType>> mostEffective = buildMostEffective();
    private static Map<ElementType, List<ElementType>> lessEffective = buildLessEffective();


    public String getHexColor() {
        return fxColors.get(this);
    }

    private static Map<ElementType, String> buildColors() {
        Map<ElementType, String> output = new HashMap<ElementType, String>();
        output.put(FIRE, "#C13618");
        output.put(WATER, "#186DC1");
        output.put(GRASS, "#18C12F");
        output.put(ELECTRIC, "#FFBF00");
        output.put(ROCK, "#969174");
        output.put(NORMAL, "#CAC6B5");
        output.put(FLYING, "#D5C3ED");
        output.put(GROUND, "#B6AD82");
        return output;
    }


    private static Map<ElementType, List<ElementType>> buildLessEffective() {
        Map<ElementType, List<ElementType>> lessEffective = new HashMap<>();
        lessEffective.put(FIRE, Arrays.asList(WATER, ROCK));
        lessEffective.put(WATER, Arrays.asList(GRASS, ELECTRIC));
        lessEffective.put(GRASS, Arrays.asList(FLYING, FIRE));
        lessEffective.put(ELECTRIC, Arrays.asList(GROUND));
        lessEffective.put(GROUND, Arrays.asList(WATER, GRASS));
        lessEffective.put(FLYING, Arrays.asList(ROCK, ELECTRIC));
        lessEffective.put(ROCK, Arrays.asList(WATER, GRASS, GROUND));
        lessEffective.put(NORMAL, Arrays.asList());

        return lessEffective;
    }

    private static Map<ElementType, List<ElementType>> buildMostEffective() {
        Map<ElementType, List<ElementType>> moreEffective = new HashMap<>();
        moreEffective.put(FIRE, Arrays.asList(GRASS));
        moreEffective.put(WATER, Arrays.asList(FIRE));
        moreEffective.put(GRASS, Arrays.asList(GROUND, WATER, ELECTRIC));
        moreEffective.put(ELECTRIC, Arrays.asList(FLYING));
        moreEffective.put(GROUND, Arrays.asList(ROCK));
        moreEffective.put(FLYING, Arrays.asList(GRASS));
        moreEffective.put(ROCK, Arrays.asList(FLYING, FIRE));
        moreEffective.put(NORMAL, Arrays.asList());

        return moreEffective;
    }

    public double getEffectiveness(ElementType otherType) {
        List<ElementType> strongAgainst = mostEffective.get(this);
        if (strongAgainst.contains(otherType)) {
            return 0.5;
        }

        List<ElementType> weakAgainst = lessEffective.get(this);
        if (weakAgainst.contains(otherType)) {
            return 1.5;
        }

        return 1.0;
    }

    public String getEffectivenessString(ElementType otherType) {
        Map<Double, String> effectiveness = new HashMap<>();
        effectiveness.put(0.5, "It's not very effective");
        effectiveness.put(1.0, "It's effective");
        effectiveness.put(1.5, "It's super effective");
        double multiplier = getEffectiveness(otherType);
        return effectiveness.get(multiplier);
    }
}