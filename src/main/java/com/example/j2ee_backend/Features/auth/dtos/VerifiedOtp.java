package com.example.j2ee_backend.Features.auth.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifiedOtp {
    public String email;
    public String otptCode;

    public VerifiedOtp(
            String email,
            String optCode
    )
    {
        this.email = email;
        this.otptCode = optCode;
    }
}
