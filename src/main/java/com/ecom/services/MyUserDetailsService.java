package com.ecom.services;

import com.ecom.model.User;
import com.ecom.model.UserPrinciple;
import com.ecom.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrinciple(user);
    }
}
