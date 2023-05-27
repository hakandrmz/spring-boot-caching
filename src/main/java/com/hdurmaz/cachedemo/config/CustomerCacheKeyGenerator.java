package com.hdurmaz.cachedemo.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

public class CustomerCacheKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return "customer_with_id" + "_"
                + StringUtils.arrayToDelimitedString(params, "_");
    }
}