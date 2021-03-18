package com.darkdevil.springbatchexample3.service;

import com.darkdevil.springbatchexample3.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> listAllCustomers();
    public List<Customer> listAllCustomersNotInCustomerBackUp();
}
