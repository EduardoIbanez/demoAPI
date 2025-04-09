package com.example.demoBCI.Controller;

import com.example.demoBCI.DTO.Request.UserRequestDTO;
import com.example.demoBCI.DTO.Response.UserResponseDTO;
import com.example.demoBCI.Service.CreateUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final CreateUserService createUserService;

    public RegisterController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/create")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO user){

        return createUserService.createUser(user);
    }
}
