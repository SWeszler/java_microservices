package com.example.users.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;

@Data
public class UserRequestDto {
    @NotEmpty(message = "Username is mandatory")
    private String username;

    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    private String password;
}
