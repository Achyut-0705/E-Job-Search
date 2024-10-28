package com.e_job_search.services;

import com.e_job_search.model.User;
import com.e_job_search.repositories.UserRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User createUser(User user) {
        return repo.save(user);
    }

    public User getUserById(String id) {
        return repo.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id not found");
        }

        boolean userExists = repo.existsById(user.getId());

        if (!userExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return repo.save(user);
    }

    public boolean deleteUser(@NotNull User user) {
        if (user.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id not found");

        boolean userExists = repo.existsById(user.getId());

        if (!userExists)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");

        repo.deleteById(user.getId());

        return true;
    }

    public boolean deleteUserById(@NotNull String id) {
        boolean userExists = repo.existsById(id);

        if (!userExists)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exists");

        repo.deleteById(id);
        return true;
    }
}
