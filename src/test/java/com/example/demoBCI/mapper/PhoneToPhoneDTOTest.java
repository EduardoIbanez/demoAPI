package com.example.demoBCI.mapper;

import com.example.demoBCI.dto.response.PhoneResponseDTO;
import com.example.demoBCI.entity.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class PhoneToPhoneDTOTest {

    @InjectMocks
    private PhoneToPhoneDTO phoneToPhoneDTO;

    @Test
    void map() {
        Phone phone = new Phone(1L,1111111,1,1,"a-b-c-d");
        PhoneResponseDTO phoneDto = phoneToPhoneDTO.map(phone);

        Assertions.assertNotNull(phoneDto);

    }
}