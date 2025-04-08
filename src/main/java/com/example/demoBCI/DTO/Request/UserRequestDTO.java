package com.example.demoBCI.DTO.Request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private List<PhoneRequestDTO> phones;
}
