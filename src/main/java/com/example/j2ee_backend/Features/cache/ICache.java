package com.example.j2ee_backend.Features.cache;

import com.example.j2ee_backend.Features.cache.dtos.GetCacheRequest;
import com.example.j2ee_backend.Features.cache.dtos.SetCacheRequest;

public interface ICache 
{
    <T> T getValue(GetCacheRequest request);
    void setValue(SetCacheRequest request);
}

