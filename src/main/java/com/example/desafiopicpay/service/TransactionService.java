package com.example.desafiopicpay.service;

import com.example.desafiopicpay.domain.Transaction;
import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.exceptions.errors.AuthorizationTransacionException;
import com.example.desafiopicpay.repository.TransactionRepository;
import com.example.desafiopicpay.request.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import static com.example.desafiopicpay.enums.errorsMessage.AuthorizationTransactionMessage.TRANSACAO_NAO_AUTORIZADA;

@Service
@AllArgsConstructor
public class TransactionService {
    private UserService userService;
    private TransactionRepository transactionRepository;
    private RestTemplate template;

    private void createTransaction(TransactionRequest transactionRequest){
        User sender = userService.findById(transactionRequest.getSenderId());

        User receiver = userService.findById(transactionRequest.getReceiverId());

        userService.validationTransaction(sender,transactionRequest.getValue());

        if(!authorizedTransaction(sender, transactionRequest.getValue())){
            throw new AuthorizationTransacionException(TRANSACAO_NAO_AUTORIZADA.getDescription());
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getValue());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setDateTransfer(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionRequest.getValue()));
        receiver.setBalance(sender.getBalance().add(transactionRequest.getValue()));

    }

    public boolean authorizedTransaction(User sender, BigDecimal value){
        ResponseEntity<Map> authoriaztionResponse = template.getForEntity(
                "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(authoriaztionResponse.getStatusCode() == HttpStatus.OK && authoriaztionResponse.getBody().get("message") == "Autorizado"){
            return true;
        } else return false;

    }
}
