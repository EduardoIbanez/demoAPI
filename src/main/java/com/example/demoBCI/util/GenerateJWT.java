package com.example.demoBCI.util;

import com.example.demoBCI.dto.request.UserRequestDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;


@Component
public class GenerateJWT {

    private int expiration = 3600000;

    public SecretKey generateKey(){

        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(UserRequestDTO userRequestDTO, SecretKey secretKey){
        return
                Jwts.builder()
                .setSubject(userRequestDTO.getName())
                .issuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }


}

