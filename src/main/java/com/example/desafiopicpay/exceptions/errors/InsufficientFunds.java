package com.example.desafiopicpay.exceptions.errors;

public class InsufficientFunds extends RuntimeException {
    public InsufficientFunds(String message) {
        super(message);
    }

    public InsufficientFunds(String message, Throwable cause) {
        super(message, cause);
    }
}
