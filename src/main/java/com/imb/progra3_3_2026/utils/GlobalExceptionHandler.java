package com.imb.progra3_3_2026.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorResponseDTO.FieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorResponseDTO.FieldError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación",
                errors
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocurrió un error interno en el servidor: " + ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
