package com.noname.steps;

import com.noname.step.Gui;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show allure report with neither steps nor setUp block nor tearDown block
 */
public class ExampleWithoutSteps {

    @Test
    public void trivialTest() {
        Gui.logTestDescription("It's the step without @Step annotation");
        assertThat(true, is(true));
    }
}
