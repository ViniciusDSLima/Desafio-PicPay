package com.example.desafiopicpay.exceptions.errors;

public class NoficiationException extends RuntimeException {
    public NoficiationException(String message) {
    }

    public NoficiationException(String message, Throwable cause) {
        super(message, cause);
    }
}
