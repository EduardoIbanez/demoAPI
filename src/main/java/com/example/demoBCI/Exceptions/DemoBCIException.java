package com.example.demoBCI.Exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DemoBCIException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public DemoBCIException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
