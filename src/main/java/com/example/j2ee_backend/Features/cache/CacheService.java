package com.example.j2ee_backend.Features.cache;

import com.example.j2ee_backend.Features.cache.dtos.CacheProvider;
import com.example.j2ee_backend.Features.cache.dtos.GetCacheRequest;
import com.example.j2ee_backend.Features.cache.dtos.SetCacheRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CacheService 
{
    private final Map<String, ICache> _cacheInstances;

    public CacheService(Map<String, ICache> cacheInstances)
    {
        _cacheInstances = cacheInstances;
    }

    public ICache createInstance(CacheProvider provider)
    {
        return _cacheInstances.get(provider.toString());
    }

    public <T> T getValue(GetCacheRequest<Object> req)
    {
        var instance = createInstance(req.cacheProvider);
        return instance.getValue(req);
    }

    public void setValue(SetCacheRequest req)
    {
        var instance = createInstance(req.cacheProvider);
        instance.setValue(req);
    }
}
