package com.example.desafiopicpay.exceptions.errors;

public class ValueNotAllowed extends RuntimeException {
    public ValueNotAllowed(String message) {
    }

    public ValueNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }
}
