package com.example.j2ee_backend.Features.auth.repositories;

import com.example.j2ee_backend.Domain.entities.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long>
{
    RefreshToken findByToken(String refreshToken);
}
