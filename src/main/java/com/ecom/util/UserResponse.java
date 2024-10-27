package com.ecom.util;

import com.ecom.model.User;
import net.minidev.json.annotate.JsonIgnore;

public class UserResponse extends User {
    @Override
    @JsonIgnore
    public String getPassword() {
        return null;
    }
}
