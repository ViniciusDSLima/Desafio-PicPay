package com.example.desafiopicpay.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private BigDecimal value;
    private String senderId;
    private String receiverId;
}
