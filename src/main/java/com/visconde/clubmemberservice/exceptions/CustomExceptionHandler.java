package com.visconde.clubmemberservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AlreadyRegisteredClientException.class)
    public ResponseEntity<String> handlerAlreadyRegisteredMember(AlreadyRegisteredClientException exception){
        return ResponseEntity.status(CONFLICT).body(exception.getMessage());
    }

}
