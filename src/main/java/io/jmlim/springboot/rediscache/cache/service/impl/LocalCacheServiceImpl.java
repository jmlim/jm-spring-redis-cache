package io.jmlim.springboot.rediscache.cache.service.impl;

import io.jmlim.springboot.rediscache.cache.service.LocalCacheService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocalCacheServiceImpl implements LocalCacheService {

    private final Map<String, Object> caches = new ConcurrentHashMap<>();

    /**
     * 특정 캐시 업데이트
     *
     * @param cacheKey
     */
    @Override
    public void updateCache(String cacheKey) {

    }

    /**
     * 캐시데이터 가져오기.
     *
     * @return
     */
    @Override
    public Map<String, Object> getCaches() {
        return null;
    }
}
