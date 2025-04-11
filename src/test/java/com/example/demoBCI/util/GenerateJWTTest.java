package com.example.demoBCI.util;

import com.example.demoBCI.dto.request.PhoneRequestDTO;
import com.example.demoBCI.dto.request.UserRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.crypto.SecretKey;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GenerateJWTTest {

    @InjectMocks
    private GenerateJWT generateJWT;

    @Test
    void generateKey() {
        SecretKey key = generateJWT.generateKey();

        Assertions.assertNotNull(key);
    }

    @Test
    void generateToken() {
        PhoneRequestDTO phoneRequestDto = new PhoneRequestDTO(1111111,1,1);
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phoneRequestDto);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@a.com","abcdE1",listPhonesRequest);
        int expiration = 3600000;

        SecretKey key = generateJWT.generateKey();

        String token = generateJWT.generateToken(userDto,key);

        Assertions.assertNotNull(token);







    }
}