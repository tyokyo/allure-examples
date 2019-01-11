package com.noname.steps;

import com.noname.helper.ApplicationHelper;
import com.noname.model.Page;
import com.noname.model.User;
import com.noname.step.Gui;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show allure report with multiple setUp/tearDown blocks
 */
public class ExampleWithStepsAndMultipleSetUps {

    @BeforeClass
    public void beforeClass() {
        ApplicationHelper.setUpApplication("http://127.0.0.1", 80, 600);
        Gui.setBaseUrl("http://127.0.0.1");
    }

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

    @AfterClass
    public void afterClass() {
        ApplicationHelper.tearDownApplication();
    }
}
