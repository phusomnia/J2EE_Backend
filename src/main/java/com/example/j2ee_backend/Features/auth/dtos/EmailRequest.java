package com.example.j2ee_backend.Features.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailRequest {
    public String to;
    public String subject;
    public String body;
}

