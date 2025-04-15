package com.example.demoBCI.exceptions;

import com.example.demoBCI.dto.response.ErrorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@DataJpaTest
class ExceptionHandlerTest {

    @InjectMocks
    private ExceptionHandler exceptionHandler;

    @Test
    void requestHandleConflict() {

        DemoBCIException ex = new DemoBCIException("error", HttpStatus.OK);

        ErrorDTO error = new ErrorDTO();
        error.setMensaje("error");

        ResponseEntity<ErrorDTO> errorResponse = exceptionHandler.requestHandleConflict(ex);

        Assertions.assertNotNull(errorResponse);



    }
}