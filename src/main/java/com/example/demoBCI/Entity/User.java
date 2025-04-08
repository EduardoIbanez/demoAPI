package com.example.demoBCI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    public final String uuid = UUID.randomUUID().toString();
    public String name;
    public String email;
    public String password;
    public LocalDateTime created;
    public LocalDateTime modified;
    public LocalDateTime lastLogin;
    public String token;
    public Boolean isActive;

}
