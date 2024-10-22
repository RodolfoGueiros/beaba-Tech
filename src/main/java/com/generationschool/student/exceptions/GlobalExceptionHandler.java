package com.generationschool.student.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Tratamento para erros de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Coleta todos os erros de validação
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField(); // Nome do campo que falhou
            String errorMessage = error.getDefaultMessage(); // Mensagem de erro
            errors.put(fieldName, errorMessage); // Adiciona ao mapa de erros
        });

        // Retorna a resposta com status 400 (Bad Request) e as mensagens de erro
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
