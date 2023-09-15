package com.example.desafiopicpay.enums.errorsMessage;

public enum InsufficientFundsMessage {

    SALDO_INSUFICIENTE_MESSAGE("O saldo e insuficiente para o valor da transferencia.");

    private String description;

    private InsufficientFundsMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
