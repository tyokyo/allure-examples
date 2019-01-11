package com.noname.helper;

import com.noname.model.WebElement;
import io.qameta.allure.Step;

public class WebActionHelper {

    @Step("Clear element {0} and fill with {1}")
    public static void clearAndFill(WebElement element, String value) {
        clear(element);
        setKeys(element, value);
    }

    @Step("Clear element with xpath {element.xpath}")
    public static void clear(WebElement element) {
    }

    @Step("Send {value} to the element with xpath {element.xpath}")
    public static void setKeys(WebElement element, String value) {
    }

    @Step("Click on the element with xpath {element.xpath}")
    public static void click(WebElement element) {
    }

}
