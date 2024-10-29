package com.e_job_search.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
    private String fullName;

    private String email;

    private Date createdAt;

    private Date updatedAt;
}
