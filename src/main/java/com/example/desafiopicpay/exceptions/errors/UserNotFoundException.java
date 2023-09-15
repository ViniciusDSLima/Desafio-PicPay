package com.example.desafiopicpay.exceptions.errors;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
