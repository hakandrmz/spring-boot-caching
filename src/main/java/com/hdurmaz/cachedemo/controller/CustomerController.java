package com.hdurmaz.cachedemo.controller;

import com.hdurmaz.cachedemo.config.LogPerformance;
import com.hdurmaz.cachedemo.model.CreateCustomerRequest;
import com.hdurmaz.cachedemo.model.Customer;
import com.hdurmaz.cachedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @LogPerformance
    @GetMapping
    public ResponseEntity<Customer> get(@RequestParam Integer id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @LogPerformance
    @GetMapping("get-all")
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @LogPerformance
    @PostMapping
    public ResponseEntity<String> save(@RequestBody CreateCustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.save(customerRequest), HttpStatus.OK);
    }

    @LogPerformance
    @GetMapping("get-customer-by-name")
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) {
        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }

    @LogPerformance
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);
    }

    @LogPerformance
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }
}
