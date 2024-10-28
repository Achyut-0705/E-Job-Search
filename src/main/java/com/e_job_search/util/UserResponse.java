package com.e_job_search.util;

import com.e_job_search.model.User;
import net.minidev.json.annotate.JsonIgnore;

public class UserResponse extends User {
    @Override
    @JsonIgnore
    public String getPassword() {
        return null;
    }
}
