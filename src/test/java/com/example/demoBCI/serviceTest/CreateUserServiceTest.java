package com.example.demoBCI.serviceTest;

import com.example.demoBCI.constant.ConstantDemoBCI;
import com.example.demoBCI.dto.request.PhoneRequestDTO;
import com.example.demoBCI.dto.request.UserRequestDTO;
import com.example.demoBCI.dto.response.PhoneResponseDTO;
import com.example.demoBCI.entity.Phone;
import com.example.demoBCI.entity.User;
import com.example.demoBCI.exceptions.DemoBCIException;
import com.example.demoBCI.mapper.PhoneToPhoneDTO;
import com.example.demoBCI.mapper.UserDTOToUser;
import com.example.demoBCI.repository.PhoneRepository;
import com.example.demoBCI.repository.UserRepository;
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
public class CreateUserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PhoneRepository phoneRepository;
    @Mock
    private UserDTOToUser mapperUser;
    @Mock
    private PhoneToPhoneDTO mapperPhone;
    @InjectMocks
    private CreateUserService createUserService;


    @Test
    public void createUserTestOK(){
        PhoneRequestDTO phoneRequestDto = new PhoneRequestDTO(1111111,1,1);
        User user = new User("a","a@a.com","", LocalDateTime.now(),LocalDateTime.now(), LocalDateTime.now(),Mockito.anyString(),true);
        Phone phone = new Phone(1L,1111111,1,1,"a-b-c-d");
        Phone phone2 = new Phone(2L,333333,3,33,"j-k-l-m");
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phoneRequestDto);

        List<Phone> listPhone = new ArrayList<>();

        listPhone.add(phone);
        listPhone.add(phone2);

        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@a.com","abcdE1",listPhonesRequest);
        PhoneResponseDTO phoneDto = new PhoneResponseDTO(1111111,1,1);


        //Mockito.when(userRepository.findByEmail("aaa@b.com")).thenReturn(user);
        Mockito.when(userRepository.findByEmail("bbb@b.com")).thenReturn(user);
        Mockito.when(mapperUser.map(userDto)).thenReturn(user);
        Mockito.when(userRepository.findByUuid(user.getUuid())).thenReturn(user);
        Mockito.when(mapperPhone.map(phone)).thenReturn(phoneDto);
        Mockito.when(phoneRepository.findByUuidUser(user.getUuid())).thenReturn(listPhone);

        Assertions.assertNotNull(createUserService.createUser(userDto));
    }

    @Test()
    public void createUserTestErrorEmail(){
        PhoneRequestDTO phoneRequestDto = new PhoneRequestDTO(1111111,1,1);
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phoneRequestDto);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa","abcdE1",listPhonesRequest);

        DemoBCIException ex = Assertions.assertThrows(DemoBCIException.class, () -> createUserService.createUser(userDto));

        Assertions.assertEquals(ConstantDemoBCI.EMAIL_ERROR, ex.getMessage());

    }

    @Test()
    public void createUserTestErrorPass(){
        PhoneRequestDTO phoneRequestDto = new PhoneRequestDTO(1111111,1,1);
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phoneRequestDto);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@mail.com","abcd",listPhonesRequest);

        DemoBCIException ex = Assertions.assertThrows(DemoBCIException.class, () -> createUserService.createUser(userDto));

        Assertions.assertEquals(ConstantDemoBCI.PASSWORD_ERROR, ex.getMessage());

    }

    @Test()
    public void createUserTestErrorRegisterEmail(){
        PhoneRequestDTO phoneRequestDto = new PhoneRequestDTO(1111111,1,1);
        List<PhoneRequestDTO> listPhonesRequest = new ArrayList<>();
        listPhonesRequest.add(phoneRequestDto);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@mail.com","abcdA1",listPhonesRequest);

        User user = new User("a","aaa@mail.com","", LocalDateTime.now(),LocalDateTime.now(), LocalDateTime.now(),"",true);

        Mockito.when(userRepository.findByEmail("aaa@mail.com")).thenReturn(user);

        DemoBCIException ex = Assertions.assertThrows(DemoBCIException.class, () -> createUserService.createUser(userDto));

        Assertions.assertEquals(ConstantDemoBCI.EMAIL_REGISTER_ERROR, ex.getMessage());

    }
}
