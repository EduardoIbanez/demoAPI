package com.example.demoBCI.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idPhone;
    public int number;
    public int cityCode;
    public int countryCode;
    public String uuidUser;
}
