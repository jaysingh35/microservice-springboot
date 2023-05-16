package com.bankapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.bankapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
