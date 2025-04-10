package com.example.demoBCI.serviceTest;

import com.example.demoBCI.dto.request.PhoneRequestDTO;
import com.example.demoBCI.dto.request.UserRequestDTO;
import com.example.demoBCI.dto.response.PhoneResponseDTO;
import com.example.demoBCI.entity.Phone;
import com.example.demoBCI.entity.User;
import com.example.demoBCI.mapper.PhoneToPhoneDTO;
import com.example.demoBCI.mapper.UserDTOToUser;
import com.example.demoBCI.repository.PhoneRepository;
import com.example.demoBCI.repository.UserRepository;
import com.example.demoBCI.service.CreateUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
        List<PhoneRequestDTO> listPhones = new ArrayList<>();
        listPhones.add(phoneRequestDto);
        UserRequestDTO userDto = new UserRequestDTO("Ever","aaa@a.com","abcdE1",listPhones);
        PhoneResponseDTO phoneDto = new PhoneResponseDTO(1111111,1,1);
        User user = new User("a","aaa@acom","", LocalDateTime.now(),LocalDateTime.now(), LocalDateTime.now(),"",true);
        Phone phone = new Phone(Mockito.anyLong(),1111111,1,1,"");
        Mockito.when(userRepository.findByEmail("aaa@acom")).thenReturn(user);
        Mockito.when(mapperUser.map(userDto)).thenReturn(user);
        Mockito.when(userRepository.findByUuid(user.getUuid())).thenReturn(user);
        Mockito.when(mapperPhone.map(phone)).thenReturn(phoneDto);
        Assertions.assertNotNull(createUserService.createUser(userDto));
    }
}
