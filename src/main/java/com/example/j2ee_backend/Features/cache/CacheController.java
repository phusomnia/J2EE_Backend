package com.example.j2ee_backend.Features.cache;

import com.example.j2ee_backend.Features.cache.dtos.GetCacheRequest;
import com.example.j2ee_backend.Features.cache.dtos.SetCacheRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "Cache")
@RequestMapping("api/v1/cache")
public class CacheController {
    private final CacheService _cacheService;

    public CacheController(CacheService cacheService)
    {
        _cacheService = cacheService;
    }

    @PostMapping("/get")
    public ResponseEntity<?> getValue(@RequestBody GetCacheRequest<?> req)
    {
        try {
            var result = _cacheService.getValue(new GetCacheRequest<>(req.cacheProvider, req.key, Object.class));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/set")
    public ResponseEntity<?> setValue(@RequestBody SetCacheRequest req)
    {
        try {
            _cacheService.setValue(req);
            return ResponseEntity.status(HttpStatus.OK).body(req.value);
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

