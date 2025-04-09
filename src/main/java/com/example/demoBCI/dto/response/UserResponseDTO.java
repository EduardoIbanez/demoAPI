package com.example.demoBCI.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserResponseDTO {

    private String name;
    private String email;
    private String password;
    private String uuid;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
    private List<PhoneResponseDTO> phones;
}
