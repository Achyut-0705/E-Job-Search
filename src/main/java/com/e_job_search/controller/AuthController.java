// TODO: Implement login and register for users

package com.e_job_search.controller;

import com.e_job_search.dtos.AuthUserDto;
import com.e_job_search.model.User;
import com.e_job_search.services.AuthService;
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
    public String login(@RequestBody User user) {
        return service.login(user);
    }

    @PostMapping("/register")
    public AuthUserDto register(@RequestBody User user) {
        return service.register(user);
    }
}
