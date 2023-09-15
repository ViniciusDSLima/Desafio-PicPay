package com.example.desafiopicpay.enums.errorsMessage;

public enum AuthorizationTransactionMessage {

    TRANSACAO_NAO_AUTORIZADA("transacao nao autorizada");

    private String description;

    private AuthorizationTransactionMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
