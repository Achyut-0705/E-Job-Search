package com.e_job_search.controller;

import com.e_job_search.dao.UserDao;
import com.e_job_search.dtos.AuthUserDto;
import com.e_job_search.model.User;
import com.e_job_search.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDao userObj) throws Exception {
        User user = modelMapper.map(userObj, User.class);

        return ResponseEntity.ok(service.login(user));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthUserDto> register(@RequestBody UserDao userObj) throws Exception {
        User user = modelMapper.map(userObj, User.class);

        User createUser = service.register(user);

        return ResponseEntity.ok(modelMapper.map(createUser, AuthUserDto.class));
    }
}
