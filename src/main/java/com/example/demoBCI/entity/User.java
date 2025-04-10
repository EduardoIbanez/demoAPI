package com.example.demoBCI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

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
