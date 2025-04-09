package com.example.demoBCI.repository;

import com.example.demoBCI.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByUuidUser(String uuidUser);
}
