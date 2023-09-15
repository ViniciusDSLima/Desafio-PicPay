package com.example.desafiopicpay.exceptions.errors;

public class ValidacaoLojistaTransacao extends RuntimeException{

    public ValidacaoLojistaTransacao(String message) {
        super(message);
    }

    public ValidacaoLojistaTransacao(String message, Throwable cause) {
        super(message, cause);
    }
}
