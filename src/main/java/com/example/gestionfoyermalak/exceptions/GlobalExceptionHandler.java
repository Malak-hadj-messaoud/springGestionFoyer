package com.example.gestionfoyermalak.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(RessourceNotFoundException exception,
                                                                        WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "NOT_FOUND"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}