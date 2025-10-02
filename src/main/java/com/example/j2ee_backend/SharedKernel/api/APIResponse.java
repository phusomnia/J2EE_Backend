package com.example.j2ee_backend.SharedKernel.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
public class APIResponse <T> extends BaseResponse {
    private T data;
    private Map<String, Object> metadata = Collections.emptyMap();

    public APIResponse(){}

    public APIResponse(
            int status,
            String message) {
        this(status, message, null, null);
    }

    public APIResponse(
            int status,
            String message,
            T data) {
        this(status, message, data, null);
    }

    public APIResponse(
            int status,
            String message,
            T data,
            Map<String, Object> metadata
    )
    {
        super(status, message);
        this.data = data;
        this.metadata = metadata;
    }
}
