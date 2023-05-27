package com.hdurmaz.cachedemo.bootstrap;

import com.github.javafaker.Faker;
import com.hdurmaz.cachedemo.model.Customer;
import com.hdurmaz.cachedemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        if (customerRepository.findAll().isEmpty()) {
            Faker faker = new Faker();
            List<Customer> list = List.of(
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build(),
                    Customer.builder().name(faker.name().firstName()).company(faker.company().name()).build()
            );
            customerRepository.saveAll(list);
        }
    }
}
