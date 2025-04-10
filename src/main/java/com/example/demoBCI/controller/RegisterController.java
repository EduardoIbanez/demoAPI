package com.example.demoBCI.controller;

import com.example.demoBCI.dto.request.UserRequestDTO;
import com.example.demoBCI.dto.response.UserResponseDTO;
import com.example.demoBCI.service.CreateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterController {

    private final CreateUserService createUserService;

    public RegisterController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user){
        return new ResponseEntity<>(createUserService.createUser(user), HttpStatus.CREATED);
    }
}
