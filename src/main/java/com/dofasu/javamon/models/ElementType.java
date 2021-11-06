package com.dofasu.javamon.models;

import java.util.HashMap;
import java.util.Map;

public enum ElementType {
    FIRE, WATER, GRASS, ELECTRIC, GROUND, NORMAL, ICE, FIGHTING, POISON, FLYING, PSYCHIC, BUG, ROCK,
    GHOST, DARK, DRAGON, STEEL, FAIRY;

    private static Map<ElementType, String> fxColors = buildColors();

    public String getHexColor() {
        return fxColors.get(this);
    }

    private static Map<ElementType, String> buildColors() {
        Map<ElementType, String> output = new HashMap<ElementType, String>();
        output.put(FIRE, "#C13618");
        output.put(WATER, "#186DC1");
        output.put(GRASS, "#18C12F");
        output.put(ELECTRIC, "#FFBF00");
        output.put(GROUND, "#B6AD82");
        output.put(NORMAL, "#CAC6B5");
        output.put(ICE, "#9BE1E0");
        output.put(FIGHTING, "#764230");
        output.put(POISON, "#792A9C");
        output.put(FLYING, "#D5C3ED");
        output.put(PSYCHIC, "#BA22C7");
        output.put(BUG, "#95AB3A");
        output.put(ROCK, "#969174");
        output.put(GHOST, "#64507A");
        output.put(DARK, "#494339");
        output.put(DRAGON, "#6722D1");
        output.put(STEEL, "#9D9D9D");
        output.put(FAIRY, "#E98BC4");
        return output;
    }
}