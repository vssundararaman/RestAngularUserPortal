package com.springrest.userportal.controller;

import com.springrest.userportal.model.Customer;
import com.springrest.userportal.repository.CustomerRepository;
import com.springrest.userportal.validator.AuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/rest")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AuthValidator authValidator;

    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers(@RequestHeader(value = "Authorization", required = false) String authorization) {

        authValidator.validateAuthorization(authorization);

        return customerRepository.findAll();
    }

    @PostMapping("/saveCustomer")
    public Iterable<Customer> saveCustomer(@RequestBody Customer customer, @RequestHeader(value = "Authorization", required = false) String authorization) {

        authValidator.validateAuthorization(authorization);

        customerRepository.save(customer);

        return customerRepository.findAll();
    }

    @PutMapping("/updateCustomer")
    public Iterable<Customer> updateCustomer(@RequestBody Customer customer, @RequestHeader(value = "Authorization", required = false) String authorization) {

        authValidator.validateAuthorization(authorization);

        customerRepository.save(customer);

        return customerRepository.findAll();
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public Iterable<Customer> deleteCustomer(@PathVariable String id, @RequestHeader(value = "Authorization", required = false) String authorization) {

        System.out.println("Inside the Delete");

        authValidator.validateAuthorization(authorization);

        customerRepository.deleteById(id);

        return customerRepository.findAll();
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<Customer> getCustomer(@PathVariable String id, @RequestHeader(value = "Authorization", required = false) String authorization) {

        authValidator.validateAuthorization(authorization);

        return customerRepository.findById(id);
    }
}
