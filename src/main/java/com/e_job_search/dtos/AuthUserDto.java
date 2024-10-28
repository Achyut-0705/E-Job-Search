package com.e_job_search.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
    private String id, fullName, email, createdAt, updatedAt;
}
