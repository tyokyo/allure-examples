package com.noname.behaviour;

import com.noname.helper.ApplicationHelper;
import com.noname.model.Page;
import com.noname.model.User;
import com.noname.step.Gui;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show how to use allure annotations for behaviour mapping
 */
@Epic("Authentication")
public class AuthenticationTest {

    @BeforeMethod
    public void beforeMethod() {
        ApplicationHelper.setUpApplication("http://127.0.0.1", 80, 600);
        Gui.setBaseUrl("http://127.0.0.1");
        Gui.setUpUi("chrome", 5L, 1024, 800);
    }

    @Test
    @Feature("Logging in")
    @Story("Existent user can log in")
    public void loginTest() {
        User existentUser = User.builder().email("qwe@gmail.com").password("qwerty").build();

        Gui.open(Page.MAIN);
        Gui.load(Page.LOGIN);
        Gui.logInAs(existentUser);

        assertThat(Gui.isMyOrdersListOpened(), is(true));
    }

    @Test
    @Feature("Registration")
    @Story("New user can sign in and checkout an order")
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
        ApplicationHelper.tearDownApplication();
    }
}
