package com.noname.step;

import com.noname.helper.WebActionHelper;
import com.noname.model.Page;
import com.noname.model.PaymentCard;
import com.noname.model.WebElement;
import com.noname.model.User;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Gui {

    public static void logTestDescription(String description) {
        log.info(description);
    }

    @Step
    public static void log(String message) {
        log.info(message);
    }

    @Step
    public static void setDriver(String browser) {
        log.info("Setting driver for {}.", browser);
    }

    @Step("Set implicit wait to {value}")
    public static void setImplicitWait(Long value) {
        log("Setting implicit wait = " + value);
    }

    @Step
    public static void setBaseUrl(String url) {
    }

    @Step("Change dimension to height = {1},  width = {0}")
    public static void setDimension(int width, int height) {
    }

    @Step("Open {page.name}")
    public static void open(Page page) {
        log.info("Opening {}", page.getName());
    }

    @Step("Load {page.name} with {page.pathParameter}")
    public static void load(Page page) {
        log.info("Loading {}", page.getPathParameter());
    }

    @Step("Log in as {user.email}")
    public static void logInAs(User user) {
        WebActionHelper.clearAndFill(WebElement.EMAIL, user.getEmail());
        WebActionHelper.clearAndFill(WebElement.PASSWORD, user.getPassword());
        WebActionHelper.click(WebElement.SUBMIT);
    }

    @Step("Register {user.name}, {user.surname}")
    public static void registerUser(User user) {
    }

    @Step
    public static void killDriver() {
        log("killing driver");
    }

    @Step
    public static void chooseThing(String category, String item, String size, int count) {
    }

    @Step
    public static void finishCheckout(PaymentCard card) {
    }

    @Step
    public static void setUpUi(String browser, Long wait, int width, int height) {
        setDriver(browser);
        setImplicitWait(wait);
        setDimension(width, height);
    }

    public static boolean isMyOrdersListOpened() {
        return true;
    }

    public static boolean isCheckoutFinishedSucessfully() {
        return true;
    }

}
