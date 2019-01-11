package com.noname.behaviour;

import com.noname.helper.ApplicationHelper;
import com.noname.model.Page;
import com.noname.model.PaymentCard;
import com.noname.model.User;
import com.noname.step.Gui;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
To show how to use allure annotations for behaviour mapping
 */
@Epic("Checkout")
public class CheckoutTest {

    @BeforeMethod
    public void beforeMethod() {
        ApplicationHelper.setUpApplication("http://127.0.0.1", 80, 600);
        Gui.setBaseUrl("http://127.0.0.1");
        Gui.setUpUi("chrome", 5L, 1024, 800);
    }

    @Test
    @Features({@Feature("Logging in"), @Feature("Checkout")})
    @Story("Existent user can log in and checkout an order")
    public void checkoutExistentUserTest() {
        User existentUser = User.builder().email("qwe@gmail.com").password("qwerty").build();

        Gui.load(Page.LOGIN);
        Gui.logInAs(existentUser);
        Gui.open(Page.CHECKOUT);
        Gui.chooseThing("clothes", "t-shirt", "M", 2);
        Gui.finishCheckout(PaymentCard.DEFAULT);

        assertThat(Gui.isCheckoutFinishedSucessfully(), is(true));
    }

    @Test
    @Feature("Registration")
    @Feature("Checkout")
    @Story("New user can sign in and checkout an order")
    public void checkoutNewUserTest() {
        User newUser = User.builder().email("qwe@gmail.com").password("qwerty").name("Joe").surname("Smith").build();

        Gui.load(Page.REGISTER);
        Gui.registerUser(newUser);
        Gui.load(Page.CHECKOUT);
        Gui.chooseThing("gadgets", "iPhone", "X", 1);
        Gui.finishCheckout(PaymentCard.DEFAULT);

        assertThat(Gui.isCheckoutFinishedSucessfully(), is(true));
    }

    @AfterMethod
    public void afterMethod() {
        Gui.killDriver();
        ApplicationHelper.tearDownApplication();
    }
}
