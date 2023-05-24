package com.hdurmaz.cachedemo.service;

import com.hdurmaz.cachedemo.model.CreateCustomerRequest;
import com.hdurmaz.cachedemo.model.Customer;
import com.hdurmaz.cachedemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Cacheable(value = "customers", keyGenerator = "customKeyGenerator")
    public List<Customer> getAllCustomers() {
        log.info("Getting all customers from database.");
        return customerRepository.findAll();
    }

    @Cacheable(value = "customers", condition = "#name=='Hakan'", keyGenerator = "customKeyGenerator")
    public List<Customer> getCustomerByName(String name) {
        log.info("Fetching all customers with name 'Hakan'");
        Optional<List<Customer>> customerList = customerRepository.getCustomerByName(name);
        return customerList.orElseThrow(() -> new RuntimeException("Customer not found with name: " + name));
    }

    @CachePut(cacheNames = "customers", keyGenerator = "customKeyGenerator")
    //updating cache
    public String update(Customer customer) {
        customerRepository.save(customer);
        return "Customer saved with name:" + customer.getName();
    }

    @Cacheable(value = "customers", keyGenerator = "customKeyGenerator")
    public Customer getCustomer(int customerId) {
        log.info("Getting customer by id: " + customerId);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }

    @CacheEvict(value = "customers", condition = "#id", keyGenerator = "customKeyGenerator")
    public String delete(Integer id) {
        log.info("Deleting customer by id: " + id);
        customerRepository.deleteById(id);
        return "Deleted customer with id: " + id;
    }

    public String save(CreateCustomerRequest customerRequest) {
        log.info("Saving customer with name:" + customerRequest.getName());
        customerRepository.save(Customer.builder()
                .name(customerRequest.getName())
                .company(customerRequest.getCompany())
                .build());
        return "Customer saved.";
    }
}
