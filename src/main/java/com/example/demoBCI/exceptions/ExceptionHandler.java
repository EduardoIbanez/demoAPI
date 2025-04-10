package com.example.demoBCI.exceptions;

import com.example.demoBCI.dto.response.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = DemoBCIException.class)
    protected ResponseEntity<ErrorDTO> requestHandleConflict(DemoBCIException ex){
        ErrorDTO error = new ErrorDTO();
        error.setMensaje(ex.getMessage());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
