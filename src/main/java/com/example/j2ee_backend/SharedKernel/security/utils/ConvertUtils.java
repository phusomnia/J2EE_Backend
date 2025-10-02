package com.example.j2ee_backend.SharedKernel.security.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.Map;

public class ConvertUtils
{
//    private static final Gson gson = new Gson();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static <T> Map<String, Object> toMap(T value) {
//        String json = gson.toJson(value);
//        Type type = new TypeToken<Map<String, Object>>() {}.getType();
//        return gson.fromJson(json, type);
        return objectMapper.convertValue(value, new TypeReference<Map<String, Object>>(){});
    }
}
