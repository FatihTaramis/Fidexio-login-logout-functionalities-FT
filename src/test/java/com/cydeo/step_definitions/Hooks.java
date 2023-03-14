package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() throws InterruptedException {

        Driver.closeDriver();
    }
}
