package com.hdurmaz.cachedemo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new CustomCacheKeyGenerator();
    }

    @Bean("customerKeyGenerator")
    public KeyGenerator customerKeyGenerator() {
        return new CustomerCacheKeyGenerator();
    }
}
