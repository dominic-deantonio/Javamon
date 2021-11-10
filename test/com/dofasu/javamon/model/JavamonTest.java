package com.dofasu.javamon.model;

import com.dofasu.javamon.controller.Controller;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JavamonTest {

    private Javamon javamonPlayer;

    @Test
    public void decreaseHealth_shouldDecreaseHealth_whenDamageIsTaken() {
        assertEquals(20, javamonPlayer.decreaseHealth(80),.001);
    }

    @Test
    public void decreaseHealth_shouldDoNothing_whenDamageIsNotTaken() throws NullPointerException{

        try {
            assertEquals(100, javamonPlayer.decreaseHealth(0),.001);
        }
        catch (NullPointerException e) {
            assertEquals(null, e.getMessage());
        }
    }

    @Test 
    public void decreaseHealth_shouldDoNothing_whenDamageIsNegative() throws NullPointerException{

        try {
            assertEquals(100, javamonPlayer.decreaseHealth(-10),.001);
        }
        catch (NullPointerException e) {
            assertEquals(null, e.getMessage());
        }
    }


}