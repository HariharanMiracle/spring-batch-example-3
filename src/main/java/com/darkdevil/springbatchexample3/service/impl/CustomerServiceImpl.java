package com.darkdevil.springbatchexample3.service.impl;

import com.darkdevil.springbatchexample3.model.Customer;
import com.darkdevil.springbatchexample3.repository.CustomerRepository;
import com.darkdevil.springbatchexample3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Customer> listAllCustomersNotInCustomerBackUp() {
        return customerRepository.listAllCustomersNotInCustomerBackUp();
    }

}
