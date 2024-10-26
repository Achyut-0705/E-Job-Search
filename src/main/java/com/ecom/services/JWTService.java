package com.ecom.services;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken() {
        return "this is my jwt token";
    }
}
