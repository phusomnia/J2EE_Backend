package com.example.j2ee_backend.Features.real_time.cloud_storage.cloudinary;

import com.cloudinary.utils.ObjectUtils;
import com.example.j2ee_backend.Features.real_time.cloud_storage.ICloudStorage;
import com.example.j2ee_backend.SharedKernel.exception.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
public class CloudinaryStorage implements ICloudStorage 
{
    private final CloudinaryConfig _config;

    @Override
    public Boolean isConnected() {
        try {
            var pingResponse = _config.cloudinary().api().ping(ObjectUtils.emptyMap());
            return "ok".equals(pingResponse.get("status"));
        } catch (Exception e) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cloudinary connection failed");
        }
    }

    @Override
    public Map<?, ?> upload(MultipartFile file) {
        try {
            return _config.cloudinary()
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.asMap(
                            "resource_type",
                            "image",
                            "public_id",
                            file.getOriginalFilename()
                        )
                    );
        } catch (IOException e)
        {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cloudinary upload failed");
        }
    }

    @Override
    public Map<?, ?> delete(String public_id) {
        try {
            return _config.cloudinary()
                    .uploader()
                    .destroy(public_id, ObjectUtils.asMap(
                        "resource_type", 
                        "invalidate", true
                    ));
        } catch (IOException e)
        {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cloudinary delete failed");
        }
    }
}
