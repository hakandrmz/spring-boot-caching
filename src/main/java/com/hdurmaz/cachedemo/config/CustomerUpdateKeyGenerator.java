package com.hdurmaz.cachedemo.config;

import com.hdurmaz.cachedemo.model.Customer;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class CustomerUpdateKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        Customer customer = (Customer) params[0];
        return "customer_with_id_" + customer.getId();
    }
}