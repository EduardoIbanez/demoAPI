package com.example.demoBCI.Repository;

import com.example.demoBCI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUuid(String uuid);
    User findByEmail(String email);
}
