package com.noname.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Page {
    MAIN("Main page", "/"),
    LOGIN("Login page", "/login"),
    REGISTER("Register page", "/signin"),
    CHECKOUT("Checkout page", "/order/checkout/"),
    MY_ORDERS("User's orders page", "/my/orders");

    @Getter
    private String name;
    @Getter
    private String pathParameter;
}
