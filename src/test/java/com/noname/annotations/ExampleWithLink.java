package com.noname.annotations;

import com.noname.helper.ApplicationHelper;
import com.noname.model.Page;
import com.noname.model.User;
import com.noname.step.Gui;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show how can we attach different types of links to allure report: Issue, TmsLink, Link, my-link
 */
public class ExampleWithLink {

    @BeforeMethod
    @Link(name = "AllureGuide", url = "https://docs.qameta.io/allure/")
    public void beforeMethod() {
        ApplicationHelper.setUpApplication("http://127.0.0.1", 80, 600);
        Gui.setBaseUrl("http://127.0.0.1");
        Gui.setUpUi("chrome", 5L, 1024, 800);
    }

    @Test
    @Issue("AUTH-23")
    @TmsLink("21")
    @Link(name = "AllureGuide", url = "https://docs.qameta.io/allure/")
    public void loginTest() {
        User existentUser = User.builder().email("qwe@gmail.com").password("qwerty").build();
        Gui.open(Page.MAIN);
        Gui.load(Page.LOGIN);
        Gui.logInAs(existentUser);
        assertThat(Gui.isMyOrdersListOpened(), is(true));
    }

    @Test
    @Issues({@Issue("AUTH-23"), @Issue("AUTH-24")})
    @TmsLinks({@TmsLink("21"), @TmsLink("22")})
    @Link(name = "AllureGuide", url = "https://docs.qameta.io/allure/")
    @Link(name = "AllureGitHubIssue", type = "allure-issues", value = "878")
    public void signInTest() {
        User newUser = User.builder().email("qwe@gmail.com").password("qwerty").name("Joe").surname("Smith").build();
        Gui.open(Page.MAIN);
        Gui.load(Page.REGISTER);
        Gui.registerUser(newUser);
        assertThat(Gui.isMyOrdersListOpened(), is(true));
    }

    @AfterMethod
    @Link(name = "AllureGuide", url = "https://docs.qameta.io/allure/")
    public void afterMethod() {
        Gui.killDriver();
        ApplicationHelper.tearDownApplication();
    }
}
