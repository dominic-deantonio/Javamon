package com.dofasu.javamon.controller;


import org.junit.Test;

class ControllerTest {

    @Test
    public void testRandomNumbers(){

        Controller controller = Controller.getInstance();

        for(int i = 0 ; i < 100; i++){
            System.out.println(Controller.getRandomNumberBetween(0, 3));
        }
    }



}