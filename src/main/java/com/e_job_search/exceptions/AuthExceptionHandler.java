package com.e_job_search.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> badCredentialsException(BadCredentialsException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 401);
        errorDetail.put("title", "Unauthorized");
        errorDetail.put("description", "The username or password is incorrect");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDetail);
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<Map<String, Object>> accountStatusException(AccountStatusException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 403);
        errorDetail.put("title", "Forbidden");
        errorDetail.put("description", "The account is locked");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetail);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> accessDeniedException(AccessDeniedException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 403);
        errorDetail.put("title", "Forbidden");
        errorDetail.put("description", "You are not authorized to access this resource");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetail);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<Map<String, Object>> signatureException(SignatureException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 403);
        errorDetail.put("title", "Forbidden");
        errorDetail.put("description", "The JWT signature is invalid");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetail);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, Object>> expiredJwtException(ExpiredJwtException exception) {
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("status", 403);
        errorDetail.put("title", "Forbidden");
        errorDetail.put("description", "The JWT token has expired");
        errorDetail.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetail);
    }
}
