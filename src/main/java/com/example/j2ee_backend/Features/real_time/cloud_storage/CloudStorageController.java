package com.example.j2ee_backend.Features.real_time.cloud_storage;

import com.example.j2ee_backend.Features.real_time.cloud_storage.dtos.CloudProvider;
import com.example.j2ee_backend.SharedKernel.api.APIResponse;
import com.example.j2ee_backend.SharedKernel.exception.APIException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "CloudinaryStorage")
@RequestMapping("api/v1/storage/")
@RequiredArgsConstructor
public class CloudStorageController 
{
    private final CloudStorageService _service;
    
    @GetMapping("isConnected")
    public ResponseEntity<?> isConnectedAPI(CloudProvider provider) {
        try {
            _service.isConnected(provider);
            var response = new APIResponse<>(
                    HttpStatus.OK.value(),
                    "Connect"
            );
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (APIException e)
        {
            throw new APIException(e.getStatus(), e.getMessage());
        }
    }
}
