package com.springrest.userportal.repository;

import com.springrest.userportal.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
