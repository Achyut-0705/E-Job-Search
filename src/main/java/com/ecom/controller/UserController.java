package com.ecom.controller;

import com.ecom.model.User;
import com.ecom.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getAllUsers() { // TODO: add filters, limits, page number and offset
        return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathParam(value = "id") String id) {
        return service.getUserById(id);
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PatchMapping("/user")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return service.deleteUserById(id);
    }
}
