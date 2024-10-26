package com.ecom.services;

import com.ecom.model.User;
import com.ecom.util.UserReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;
    
    public String login() {
        return jwtService.generateToken();
    }

    public UserReponse register(User user) {
        return (UserReponse) userService.createUser(user);
    }
}
