package com.example.demoBCI.mapper;

import com.example.demoBCI.dto.request.UserRequestDTO;
import com.example.demoBCI.entity.User;
import com.example.demoBCI.util.GenerateJWT;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDTOToUser implements IMapper<UserRequestDTO, User> {

    private final GenerateJWT token;

    public UserDTOToUser(GenerateJWT token) {
        this.token = token;
    }

    @Override
    public User map(UserRequestDTO in) {
        User user = new User();
        user.setName(in.getName());
        user.setEmail(in.getEmail());
        user.setPassword(in.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(token.generateToken(in, token.generateKey()));
        user.setIsActive(Boolean.TRUE);
        return user;
    }
}
