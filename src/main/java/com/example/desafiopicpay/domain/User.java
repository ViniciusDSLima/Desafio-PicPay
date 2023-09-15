package com.example.desafiopicpay.domain;

import com.example.desafiopicpay.enums.TypeUser;
import com.example.desafiopicpay.request.UserRegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Users")
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
    private BigDecimal balance;

    public User(UserRegisterRequest userRegisterRequest) {
        this.name = userRegisterRequest.getName();
        this.email = userRegisterRequest.getEmail();
        this.password = userRegisterRequest.getPassword();
        this.document = userRegisterRequest.getDocument();
        this.typeUser = userRegisterRequest.getTypeUser();
        this.balance = userRegisterRequest.getBalance();
    }
}
