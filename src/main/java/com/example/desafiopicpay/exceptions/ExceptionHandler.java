package com.example.desafiopicpay.exceptions;

import com.example.desafiopicpay.exceptions.errors.NoficiationException;
import com.example.desafiopicpay.exceptions.errors.UserNotFoundException;
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
    public ResponseEntity<Error> validacaoSalfoInsuficiente(InsufficientResourcesException ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Saldo insuficiente",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValueNotAllowed.class)
    public ResponseEntity<Error> validacaoValorNaoAutorizado(ValueNotAllowed ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Nao e permitido transferir valor negativo.",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> validacaoUsuarioNaoEncontrado(UserNotFoundException ex,
                                                           HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Usuario nao encontrado",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NoficiationException.class)
    public ResponseEntity<Error> validacaoNotificacaoNaoDisponivel(NoficiationException ex,
                                                               HttpServletRequest request) {
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Service not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
