package com.example.desafiopicpay.exceptions.errors;

public class AuthorizationTransacionException extends RuntimeException {
    public AuthorizationTransacionException(String message) {
    }

    public AuthorizationTransacionException(String message, Throwable cause) {
        super(message, cause);
    }
}
