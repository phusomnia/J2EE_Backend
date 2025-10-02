package com.example.j2ee_backend.Features.real_time.cloud_storage;

import com.example.j2ee_backend.Features.real_time.cloud_storage.cloudinary.CloudinaryConfig;
import com.example.j2ee_backend.Features.real_time.cloud_storage.cloudinary.CloudinaryStorage;
import com.example.j2ee_backend.Features.real_time.cloud_storage.dtos.CloudProvider;
import com.example.j2ee_backend.SharedKernel.exception.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CloudStorageService 
{
    private final CloudinaryConfig _config;

    private ICloudStorage createInstance(CloudProvider provider)
    {
        switch (provider)
        {
            case CLOUDINARY: {
                log.info("Cloudinary instance created");
                return new CloudinaryStorage(_config);
            }
            default: 
                throw new APIException(HttpStatus.BAD_REQUEST.value(), "Invalid cloud provider");
        }
    }
    
    public Boolean isConnected(CloudProvider provider)
    {
        var instance = createInstance(provider);
        return instance.isConnected();
    }
}
