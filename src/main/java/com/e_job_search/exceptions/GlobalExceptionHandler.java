package com.e_job_search.exceptions;

import jakarta.persistence.NonUniqueResultException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<Map<String, Object>> nonUniqueResultException(NonUniqueResultException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 409);
        errorDetail.put("title", "Conflict");
        errorDetail.put("description", "Duplicate records found");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(409).body(errorDetail);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 400);
        errorDetail.put("title", "Bad Request");
        errorDetail.put("description", "Invalid request parameters");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetail);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> dataIntegrityViolationException(DataIntegrityViolationException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 500);
        errorDetail.put("title", "Bad Request");
        errorDetail.put("description", "Invalid request parameters");
        errorDetail.put("message", "Duplicate records found");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> genericException(Exception exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 500);
        errorDetail.put("title", "Internal Server Error");
        errorDetail.put("description", "An error occurred while processing the request");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
    }
}
