package com.e_job_search.services;

import com.e_job_search.model.User;
import com.e_job_search.model.UserPrinciple;
import com.e_job_search.repositories.UserRepo;
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
