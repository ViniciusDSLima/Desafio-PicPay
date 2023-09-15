package com.example.desafiopicpay.service;

import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.enums.TypeUser;
import com.example.desafiopicpay.exceptions.errors.InsufficientFunds;
import com.example.desafiopicpay.exceptions.errors.ValidacaoLojistaTransacao;
import com.example.desafiopicpay.exceptions.errors.ValueNotAllowed;
import com.example.desafiopicpay.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.example.desafiopicpay.enums.errorsMessage.InsufficientFundsMessage.SALDO_INSUFICIENTE_MESSAGE;
import static com.example.desafiopicpay.enums.errorsMessage.ValidacaoLogistaTransacaoMessage.LOGISTA_TRANSACAO_MESSAGE;
import static com.example.desafiopicpay.enums.errorsMessage.ValueNotAllowedMessage.VALOR_NAO_PODE_SER_ZERO;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void validationTransaction(User sender, BigDecimal amount){

        if(sender.getTypeUser() == TypeUser.LOJISTAS){
            throw new ValidacaoLojistaTransacao(LOGISTA_TRANSACAO_MESSAGE.getDescription());
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new InsufficientFunds(SALDO_INSUFICIENTE_MESSAGE.getDescription());
        }

        if(amount.compareTo(BigDecimal.ZERO) == 0){
            throw new ValueNotAllowed(VALOR_NAO_PODE_SER_ZERO.getDescription());
        }
    }
}
