package com.dofasu.javamon.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {


    @Test
    public void testRandomNumbers(){

        Controller controller = Controller.getInstance();

        for(int i = 0 ; i < 100; i++){
            System.out.println(Controller.getRandomNumberBetween(0, 3));
        }
    }



}