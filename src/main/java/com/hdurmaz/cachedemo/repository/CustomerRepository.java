package com.hdurmaz.cachedemo.repository;

import com.hdurmaz.cachedemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<List<Customer>> getCustomerByName(String name);
}
