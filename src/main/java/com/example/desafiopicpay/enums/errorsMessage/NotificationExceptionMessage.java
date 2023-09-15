package com.example.desafiopicpay.enums.errorsMessage;

public enum NotificationExceptionMessage {

    SERVICE_NOT_FOUND("servico de notificacao fora do ar");
    private String description;

    private NotificationExceptionMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
