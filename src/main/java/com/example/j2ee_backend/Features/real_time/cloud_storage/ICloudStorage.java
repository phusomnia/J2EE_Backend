package com.example.j2ee_backend.Features.real_time.cloud_storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ICloudStorage 
{
    Boolean isConnected();
    Map<?, ?> upload(MultipartFile file);
    Map<?, ?> delete(String public_id);
}
