package com.example.j2ee_backend.Features.cache.dtos;

public class SetCacheRequest {
    public CacheProvider cacheProvider;
    public String key;
    public Object value;

    public SetCacheRequest(
            CacheProvider cacheProvider,
            String key,
            Object value
    )
    {
        this.cacheProvider = cacheProvider;
        this.key = key;
        this.value = value;
    }
}
