package com.example.j2ee_backend.Features.real_time.cloud_storage.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig
{
    @Value("${cloudinary.url}")
    private String url;

    @Bean
    public Cloudinary cloudinary()
    {
        return new Cloudinary(url);
    };
}
