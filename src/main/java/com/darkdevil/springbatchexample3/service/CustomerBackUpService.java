package com.darkdevil.springbatchexample3.service;

import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerBackUpService {
    public List<CustomerBackUp> listAllCustomerBackUp();
    public boolean backUpCustomers();
    public boolean saveAllCustomerBackUps(List<CustomerBackUp> customerBackUpList);
    public boolean saveCustomer(CustomerBackUp customerBackUp);
}
