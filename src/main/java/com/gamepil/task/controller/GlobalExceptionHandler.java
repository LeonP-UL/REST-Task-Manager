package com.gamepil.task.controller;

import com.gamepil.task.dto.ErrorResponseDto;
import com.gamepil.task.dto.FieldErrorDto;
import com.gamepil.task.exception.AuthException;
import com.gamepil.task.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex){

        List<FieldErrorDto> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new FieldErrorDto(
                        err.getField(),
                        err.getDefaultMessage()
                )).toList();

        ErrorResponseDto response = new ErrorResponseDto(
                "Argument validation failed",
                LocalDateTime.now(),
                errors
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponseDto> handleAuthException(AuthException ex){
        ErrorResponseDto response = new ErrorResponseDto(
                ex.getMessage(),
                LocalDateTime.now(),
                List.of()
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDto> handleConflictException(ConflictException ex){
        ErrorResponseDto response = new ErrorResponseDto(
                ex.getMessage(),
                LocalDateTime.now(),
                List.of()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
