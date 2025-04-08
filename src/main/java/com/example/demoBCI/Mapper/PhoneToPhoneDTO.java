package com.example.demoBCI.Mapper;

import com.example.demoBCI.DTO.Response.PhoneResponseDTO;
import com.example.demoBCI.Entity.Phone;

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
