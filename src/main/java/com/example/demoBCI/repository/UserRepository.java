package com.example.demoBCI.repository;

import com.example.demoBCI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUuid(String uuid);
    User findByEmail(String email);
}
