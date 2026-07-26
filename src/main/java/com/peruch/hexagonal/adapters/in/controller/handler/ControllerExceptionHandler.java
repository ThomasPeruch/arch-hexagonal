package com.peruch.hexagonal.adapters.in.controller.handler;

import com.peruch.hexagonal.application.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundExceptionHandler(
            ObjectNotFoundException exception, HttpServletRequest request) {
        StandardError error = new StandardError(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
