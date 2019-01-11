package com.noname.annotations;

import com.noname.helper.ApplicationHelper;
import com.noname.model.Page;
import com.noname.model.PaymentCard;
import com.noname.model.User;
import com.noname.step.Gui;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
To show how allure report looks when we use allure java annotations: Description, Owner, Severity, Flaky
 */
public class ExampleWithAnnotations {

    @BeforeMethod
    public void beforeMethod() {
        ApplicationHelper.setUpApplication("http://127.0.0.1", 80, 600);
        Gui.setBaseUrl("http://127.0.0.1");
        Gui.setUpUi("chrome", 5L, 1024, 800);
    }

    @Test
    @Description("Test that existent user can checkout an order using the system")
    @Owner(value = "Joe Black")
    @Severity(SeverityLevel.BLOCKER)
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
    @Description("Test that new user can checkout an order using the system right after registration")
    @Owner(value = "John Smith")
    @Severity(SeverityLevel.BLOCKER)
    public void checkoutNewUserTest() {
        User newUser = User.builder().email("qwe@gmail.com").password("qwerty").name("Joe").surname("Smith").build();

        Gui.load(Page.REGISTER);
        Gui.registerUser(newUser);
        Gui.load(Page.CHECKOUT);
        Gui.chooseThing("gadgets", "iPhone", "X", 1);
        Gui.finishCheckout(PaymentCard.DEFAULT);

        assertThat(Gui.isCheckoutFinishedSucessfully(), is(true));
    }

    @Test
    @Flaky
    @Owner(value = "Vasiliy Terkin")
    @Severity(SeverityLevel.TRIVIAL)
    public void compareFigures() {
        new Random().nextBoolean();
        assertThat(new Random().nextBoolean(), is(true));
    }

    @AfterMethod
    public void afterMethod() {
        Gui.killDriver();
        ApplicationHelper.tearDownApplication();
    }
}
