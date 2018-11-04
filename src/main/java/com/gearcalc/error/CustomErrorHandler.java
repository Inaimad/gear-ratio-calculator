package com.gearcalc.error;

import com.gearcalc.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.net.ConnectException;

@ControllerAdvice
@Slf4j
public class CustomErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchNumberFormatException(NumberFormatException exception) {
        log.error("Number Format Exception. Error is: {}", exception.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchConnectionException(ConnectException exception) {
        log.error("Connection Exception. Check if the DB is running. Error is: {}", exception.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchEntityNotFoundException(EntityNotFoundException exception) {
        log.error("Entity Not Found Exception. The specified identifier is not present in the DB!" +
                " Error is: {}", exception.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
