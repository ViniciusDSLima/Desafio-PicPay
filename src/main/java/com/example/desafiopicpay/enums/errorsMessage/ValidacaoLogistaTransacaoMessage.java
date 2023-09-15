package com.example.desafiopicpay.enums.errorsMessage;

public enum ValidacaoLogistaTransacaoMessage {

    LOGISTA_TRANSACAO_MESSAGE("O lojista Nao pode realizar transferencia");

    private String description;

    private ValidacaoLogistaTransacaoMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
