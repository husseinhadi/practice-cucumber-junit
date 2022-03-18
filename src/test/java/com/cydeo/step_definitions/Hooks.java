package com.cydeo.step_definitions;


import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setUpScenario() {
        System.out.println("====Setting up browser using cucumber @Before");

    }

    @After
    public void tearDownScenario(){
        System.out.println("===Closing browser ");

    }
}
