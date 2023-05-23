package com.hdurmaz.cachedemo.service;

import com.hdurmaz.cachedemo.model.Customer;
import com.hdurmaz.cachedemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Cacheable(value = "customer", key = "#customerId")
    public Customer getCustomer(int customerId) {
        log.info("Getting customer by id: " + customerId);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.get();
    }

    @Cacheable(value = "customers")
    public List<Customer> getAllCustomers() {
        log.info("Getting all customers.");
        return customerRepository.findAll();
    }
}
