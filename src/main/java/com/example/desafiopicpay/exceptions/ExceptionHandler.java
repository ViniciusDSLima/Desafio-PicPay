package com.example.desafiopicpay.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidacaoLojistaTransacao.class)
    public ResponseEntity<Error> validacaoLojistaTransacao(ValidacaoLojistaTransacao ex,
                                                           HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "O lojista nao tem permisao para realizar a transacao",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
