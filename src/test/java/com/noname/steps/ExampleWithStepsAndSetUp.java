package com.noname.steps;

import com.noname.model.Page;
import com.noname.model.User;
import com.noname.step.Gui;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show allure report with steps and setUp/tearDown blocks
 */
public class ExampleWithStepsAndSetUp {

    @BeforeMethod
    public void beforeMethod() {
        Gui.setDriver("firefox");
        Gui.setImplicitWait(7L);
        Gui.setDimension(1024, 758);
    }

    @Test
    public void loginTest() {
        User existentUser = User.builder().email("qwe@gmail.com").password("qwerty").build();

        Gui.open(Page.MAIN);
        Gui.load(Page.LOGIN);
        Gui.logInAs(existentUser);
        assertThat(Gui.isMyOrdersListOpened(), is(true));
    }

    @Test
    public void signInTest() {
        User newUser = User.builder().email("qwe@gmail.com").password("qwerty").name("Joe").surname("Smith").build();

        Gui.open(Page.MAIN);
        Gui.load(Page.REGISTER);
        Gui.registerUser(newUser);
        assertThat(Gui.isMyOrdersListOpened(), is(true));
    }

    @AfterMethod
    public void afterMethod() {
        Gui.killDriver();
    }
}
