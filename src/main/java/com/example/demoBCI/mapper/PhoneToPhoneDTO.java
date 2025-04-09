package com.example.demoBCI.mapper;

import com.example.demoBCI.dto.response.PhoneResponseDTO;
import com.example.demoBCI.entity.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneToPhoneDTO implements IMapper<Phone, PhoneResponseDTO>{
    @Override
    public PhoneResponseDTO map(Phone in) {
        PhoneResponseDTO phones  =new PhoneResponseDTO();
        phones.setNumber(in.getNumber());
        phones.setCityCode(in.getCityCode());
        phones.setCountryCode(in.getCountryCode());
        return phones;
    }
}
