// TODO: Implement login and register for users

package com.ecom.controller;

import com.ecom.model.User;
import com.ecom.services.AuthService;
import com.ecom.util.UserReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public String login() {
        return service.login();
    }

    @PostMapping("/register")
    public UserReponse register(@RequestBody User user) {
        return service.register(user);
    }
}
