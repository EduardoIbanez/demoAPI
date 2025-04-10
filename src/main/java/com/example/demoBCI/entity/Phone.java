package com.example.demoBCI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Phone")
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idPhone;
    public int number;
    public int cityCode;
    public int countryCode;
    public String uuidUser;
}
