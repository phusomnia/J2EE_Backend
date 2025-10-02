package com.example.j2ee_backend.Domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "RefreshToken", schema = "spring")
public class RefreshToken {
    @Id
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Size(max = 36)
    @Column(name = "token", length = 36)
    private String token;

    @Size(max = 36)
    @Column(name = "account_Id", length = 36)
    private String accountId;

    @Column(name = "expiryDate")
    private Instant expiryDate;

}