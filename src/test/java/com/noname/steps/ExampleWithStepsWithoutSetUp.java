package com.noname.steps;

import com.noname.model.Page;
import com.noname.model.User;
import com.noname.step.Gui;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/*
To show allure report with steps but without setUp/tearDown blocks
 */
public class ExampleWithStepsWithoutSetUp {

    @Test
    public void loginTest() {
        Gui.setDriver("chrome");
        Gui.setImplicitWait(5L);
        Gui.setDimension(800, 600);

        User existentUser = User.builder().email("qwe@gmail.com").password("qwerty").build();

        Gui.open(Page.MAIN);
        Gui.load(Page.LOGIN);
        Gui.logInAs(existentUser);
        assertThat(Gui.isMyOrdersListOpened(), CoreMatchers.is(true));
    }

    @Test
    public void signInTest() {
        Gui.setDriver("firefox");
        Gui.setImplicitWait(7L);
        Gui.setDimension(1024, 758);

        User newUser = User.builder().email("qwe@gmail.com").password("qwerty").name("Joe").surname("Smith").build();

        Gui.open(Page.MAIN);
        Gui.load(Page.REGISTER);
        Gui.registerUser(newUser);
        assertThat(Gui.isMyOrdersListOpened(), CoreMatchers.is(true));
    }
}
