package com.example.desafiopicpay.enums.errorsMessage;

public enum ValueNotAllowedMessage {

    VALOR_NAO_PODE_SER_ZERO("O valor de transferencia nao pode ser o valor zero.");

    private String description;

    private ValueNotAllowedMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
