package com.example.demoBCI.constant;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConstantDemoBCI {
    public static final String EMAIL_ERROR= "Email inválido";
    public static final String PASSWORD_ERROR= "Contraseña inválida";
    public static final String EMAIL_REGISTER_ERROR= "El email ya está registrado";

}
