package com.example.j2ee_backend.Features.cache;

import com.example.j2ee_backend.Features.cache.dtos.GetCacheRequest;
import com.example.j2ee_backend.Features.cache.dtos.SetCacheRequest;
import com.example.j2ee_backend.SharedKernel.exception.APIException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@Component("REDIS")
@Slf4j
public class JedisCache implements ICache
{
    private final JedisConfig _config;
    private final ObjectMapper _objectMapper;

    public JedisCache(
            JedisConfig config,
            ObjectMapper objectMapper
    )
    {
        _config = config;
        _objectMapper = objectMapper;
    }

    @Override
    public <T> T getValue(GetCacheRequest request) {
        try (Jedis jedis = _config.jedisPool().getResource()) {
            String value = jedis.get(request.key);
            log.info(request.type.getName());
            if(value == null) throw new APIException(HttpStatus.BAD_REQUEST.value(), "Can't find cache");

            return (T) _objectMapper.readValue(value, request.type);
        } catch (IOException e)
        {
            throw new RuntimeException("Failed to parse JSON from Redis", e);
        }
    }

    @Override
    public void setValue(SetCacheRequest request) {
        try (Jedis jedis = _config.jedisPool().getResource()) {
            var stringJson = _objectMapper.writeValueAsString(request.value);
            jedis.set(request.key, stringJson);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize value to JSON", e);
        }
    }
}
