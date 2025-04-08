package com.example.demoBCI.DTO.Request;

import lombok.Data;

@Data
public class PhoneRequestDTO {
    public int number;
    public int cityCode;
    public int countryCode;
}
