package com.example.j2ee_backend.Features.auth.dtos;

import jakarta.validation.constraints.NotEmpty;

public class RegisterRequest 
{
    @NotEmpty(message = "Required username")
    public String username;

    @NotEmpty(message = "Required username")
    public String email;

    @NotEmpty(message = "Required username")
    public String password;
}

