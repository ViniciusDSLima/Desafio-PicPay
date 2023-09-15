package com.example.desafiopicpay.enums.errorsMessage;

public enum UserNotFoundMessage {

    USUARIO_NAO_ENCONTRADO("usuario nao encontrado");

    private String description;

    private UserNotFoundMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
