package com.example.demoBCI.Mapper;

import com.example.demoBCI.DTO.Request.UserRequestDTO;
import com.example.demoBCI.Entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDTOToUser implements IMapper<UserRequestDTO, User> {
    @Override
    public User map(UserRequestDTO in) {
        User user = new User();
        user.setName(in.getName());
        user.setEmail(in.getEmail());
        user.setPassword(in.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken("");
        user.setIsActive(Boolean.TRUE);
        return user;
    }
}
