package com.example.desafiopicpay.service;

import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.enums.TypeUser;
import com.example.desafiopicpay.exceptions.ValidacaoLojistaTransacao;
import com.example.desafiopicpay.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void validationTransaction(User sender, BigDecimal amount){
        if(sender.getTypeUser() == TypeUser.LOJISTAS){
            throw new ValidacaoLojistaTransacao("O lohista nao tem permisao para realizar a transacao ");
        }
    }
}
