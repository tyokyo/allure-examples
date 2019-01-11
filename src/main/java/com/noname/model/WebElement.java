package com.noname.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum WebElement {
    EMAIL("//input[@id='login-email']"),
    PASSWORD("//input[@id='login-pass']"),
    SUBMIT("//button[@id='login-submit']");

    String xpath;
}
