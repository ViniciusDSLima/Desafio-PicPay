package com.example.desafiopicpay.service;

import com.example.desafiopicpay.DTO.UserDTO;
import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.enums.TypeUser;
import com.example.desafiopicpay.exceptions.errors.InsufficientFunds;
import com.example.desafiopicpay.exceptions.errors.UserNotFoundException;
import com.example.desafiopicpay.exceptions.errors.ValidacaoLojistaTransacao;
import com.example.desafiopicpay.exceptions.errors.ValueNotAllowed;
import com.example.desafiopicpay.mapper.UserMapper;
import com.example.desafiopicpay.repository.UserRepository;
import com.example.desafiopicpay.request.UserRegisterRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.example.desafiopicpay.enums.errorsMessage.InsufficientFundsMessage.SALDO_INSUFICIENTE_MESSAGE;
import static com.example.desafiopicpay.enums.errorsMessage.UserNotFoundMessage.USUARIO_NAO_ENCONTRADO;
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

    @Transactional
    public UserDTO save(UserRegisterRequest userRegisterRequest){

        User user = userRepository.save(UserMapper.INSTANCE.toUser(userRegisterRequest));

        return UserMapper.INSTANCE.toUserDTO(user);
    }

    public User findById(@Valid String id){
        return (User) userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(USUARIO_NAO_ENCONTRADO.getDescription()));
    }
}
