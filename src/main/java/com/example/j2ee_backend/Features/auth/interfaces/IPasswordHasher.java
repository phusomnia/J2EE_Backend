package com.example.j2ee_backend.Features.auth.interfaces;

public interface IPasswordHasher 
{
    public String encodePassword(String rawPassword);
    public boolean validatePassword(String rawPassword, String hashedPassword);
}
