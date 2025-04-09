package com.example.demoBCI.Repository;

import com.example.demoBCI.Entity.Phone;
import com.example.demoBCI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByUuidUser(String uuidUser);
}
