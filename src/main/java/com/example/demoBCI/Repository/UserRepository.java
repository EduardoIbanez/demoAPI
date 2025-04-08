package com.example.demoBCI.Repository;

import com.example.demoBCI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findById(String uuid);
}
