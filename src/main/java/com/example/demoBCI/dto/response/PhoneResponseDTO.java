package com.example.demoBCI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponseDTO {
    private int number;
    private int cityCode;
    private int countryCode;
}
