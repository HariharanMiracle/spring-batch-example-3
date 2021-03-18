package com.darkdevil.springbatchexample3.controller;

import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import com.darkdevil.springbatchexample3.service.CustomerBackUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerBackUpController {

    @Autowired
    private CustomerBackUpService customerBackUpService;

    @GetMapping(value="customerBackUps")
    public List<CustomerBackUp> listAllCustomerBackUps(){
        return customerBackUpService.listAllCustomerBackUp();
    }

}
