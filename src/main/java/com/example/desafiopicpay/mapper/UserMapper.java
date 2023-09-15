package com.example.desafiopicpay.mapper;

import com.example.desafiopicpay.DTO.UserDTO;
import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.request.UserRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRegisterRequest userRegisterRequest);

    UserDTO toUserDTO(User user);
}
