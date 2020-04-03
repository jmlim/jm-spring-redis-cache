package io.jmlim.springboot.rediscache.cache.service;

import java.util.Map;

public interface LocalCacheService {

    /**
     * 특정 캐시 업데이트
     */
    void updateCache(String cacheKey);

    /**
     * 캐시데이터 가져오기.
     *
     * @return
     */
    Map<String, Object> getCaches();
}
