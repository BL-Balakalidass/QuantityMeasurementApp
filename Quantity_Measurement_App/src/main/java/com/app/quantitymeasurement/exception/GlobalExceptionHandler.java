package com.app.quantitymeasurement.exception;

import com.app.quantitymeasurement.exception.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO>
    handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String message =
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getDefaultMessage())
                        .collect(Collectors.joining(", "));

        ErrorResponseDTO response =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        400,
                        "Validation Error",
                        message,
                        request.getRequestURI()
                );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(QuantityMeasurementException.class)
    public ResponseEntity<ErrorResponseDTO>
    handleQuantityException(
            QuantityMeasurementException ex,
            HttpServletRequest request) {

        ErrorResponseDTO response =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        400,
                        "Quantity Measurement Error",
                        ex.getMessage(),
                        request.getRequestURI()
                );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO>
    handleGlobalException(
            Exception ex,
            HttpServletRequest request) {

        ErrorResponseDTO response =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        500,
                        "Internal Server Error",
                        ex.getMessage(),
                        request.getRequestURI()
                );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}