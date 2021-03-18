package com.darkdevil.springbatchexample3.controller;

import com.darkdevil.springbatchexample3.model.Customer;
import com.darkdevil.springbatchexample3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="customers")
    public List<Customer> listAllCustomers(){
        return customerService.listAllCustomers();
    }

}
