package com.teste.demo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.demo.services.exceptions.DataBaseException;
import com.teste.demo.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)    
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), "Resource not found", e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        StandardError err = new StandardError(Instant.now(), status.value(), "Internal server error", e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

}
