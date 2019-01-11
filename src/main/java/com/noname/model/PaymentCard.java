package com.noname.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentCard {
    DEFAULT("1234 5645 4665 0021", "06/20", "112");

    private String creditCardNumber;
    private String expireDate;
    private String creditCardCVC;
}
