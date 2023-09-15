package com.example.desafiopicpay.exceptions;

import com.example.desafiopicpay.exceptions.errors.ValidacaoLojistaTransacao;
import com.example.desafiopicpay.exceptions.errors.ValueNotAllowed;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.naming.InsufficientResourcesException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidacaoLojistaTransacao.class)
    public ResponseEntity<Error> validacaoLojistaTransacao(ValidacaoLojistaTransacao ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "O lojista nao tem permisao para realizar a transacao",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InsufficientResourcesException.class)
    public ResponseEntity<Error> validacaoLojistaTransacao(InsufficientResourcesException ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Saldo insuficiente",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValueNotAllowed.class)
    public ResponseEntity<Error> validacaoLojistaTransacao(ValueNotAllowed ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Nao e permitido transferir valor negativo.",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
