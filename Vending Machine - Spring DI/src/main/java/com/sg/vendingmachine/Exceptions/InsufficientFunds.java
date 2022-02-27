package com.sg.vendingmachine.Exceptions;

public class InsufficientFunds extends Exception {

    public InsufficientFunds(String message) {
        super(message);
    }

    public InsufficientFunds(String message, Throwable cause) {
        super(message, cause);
    }

}