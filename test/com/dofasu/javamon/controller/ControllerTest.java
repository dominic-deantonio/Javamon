package com.dofasu.javamon.controller;

import com.dofasu.javamon.model.Attack;
import com.dofasu.javamon.model.ElementType;
import com.dofasu.javamon.model.Javamon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {
    private Controller controller;
    private Javamon javamonPlayer;
    private Javamon javamonOpponent;

    @Before
    public void setUp() throws Exception {
        controller = Controller.getInstance();
        javamonPlayer = new Javamon("Pikachu", List.of(new Attack("Thunderbolt", ElementType.ELECTRIC, 80, 80)),
                "/pikachu.png", ElementType.ELECTRIC);
        javamonOpponent = new Javamon("Geodude", List.of(new Attack("Rock Throw", ElementType.ROCK, 80, 80)),
                "/geodude.png", ElementType.ROCK);
    }


    @Test
    public void getRandomOpponent_shouldReturndiffentJavaMonthanPlayer_WhenRandomOpponent() {
         controller.setPlayer(javamonPlayer);
        //System.out.println(controller.getRandomOpponent().getName());
        //System.out.println(controller.getPlayer().getName());
        assertFalse(controller.getRandomOpponent().equals(javamonPlayer));

    }

    @Test //TODO can write 2 more test case on these for different effective types
    //formula of Effectiveness = attack.getStrength() * effectiveness * 0.3
    public void calculateDamage_shouldSame_whenNonEffective() {
        Attack attack = new Attack("Flamethrower", ElementType.FIRE, 80, 80);
        assertEquals(24.0, controller.calculateDamage(attack,javamonPlayer),.001);

    }

    @Test //TODO
    //formula of Effectiveness = attack.getStrength() * effectiveness * 0.3
    public void calculateDamage_shouldbeTimesandHalf_whenMoreEffective() {
        Attack attack = new Attack("Sand Attack", ElementType.GROUND, 60, 80);
        assertEquals(27.0, controller.calculateDamage(attack,javamonPlayer),.001);

    }

    @Test //TODO
    //formula of Effectiveness = attack.getStrength() * effectiveness * 0.3
    public void calculateDamage_shouldbehalf_whenLessEffective() {
        Attack attack = new Attack("Air Slash", ElementType.FLYING, 80, 80);
        assertEquals(12.0, controller.calculateDamage(attack,javamonPlayer),.001);

    }

    @Test //TODO
    public void getRandomAttack() {

    }
}