package com.example.demoBCI.controller;


import com.example.demoBCI.dto.request.PhoneRequestDTO;
import com.example.demoBCI.dto.request.UserRequestDTO;
import com.example.demoBCI.dto.response.PhoneResponseDTO;
import com.example.demoBCI.dto.response.UserResponseDTO;
import com.example.demoBCI.service.CreateUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@DataJpaTest
class RegisterControllerTest {

    @Mock
    private CreateUserService createUserService;

    @InjectMocks
    private RegisterController registerController;
    @Test
    void createUserTest() {
        PhoneRequestDTO phone = new PhoneRequestDTO(1111111,1,1);
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phone);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@a.com","abcdE1",listPhonesRequest);

        PhoneResponseDTO phoneResponse = new PhoneResponseDTO(1111111,1,1);
        List<PhoneResponseDTO> listPhoneResponse = new ArrayList<>();
        listPhoneResponse.add(phoneResponse);
        UserResponseDTO userResponseDto = new UserResponseDTO("Ever","aaa@a.com","abcdE1","HAS5-HAS2-833H-8S8D", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),"ASDASDASDKJBKJYAS7DAS",true,listPhoneResponse);

        Mockito.when(createUserService.createUser(userDto)).thenReturn(userResponseDto);

        Assertions.assertNotNull(registerController.createUser(userDto));
    }
}