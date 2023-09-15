package com.example.desafiopicpay.controller;

import com.example.desafiopicpay.request.UserRegisterRequest;
import com.example.desafiopicpay.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity save(@RequestBody @Valid UserRegisterRequest userRegisterRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRegisterRequest));
    }
}
