package com.darkdevil.springbatchexample3.service.impl;

import com.darkdevil.springbatchexample3.model.Customer;
import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import com.darkdevil.springbatchexample3.repository.CustomerBackUpRepository;
import com.darkdevil.springbatchexample3.service.CustomerBackUpService;
import com.darkdevil.springbatchexample3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBackUpServiceImpl implements CustomerBackUpService {

    @Autowired
    private CustomerBackUpRepository customerBackUpRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<CustomerBackUp> listAllCustomerBackUp() {
        return (List<CustomerBackUp>) customerBackUpRepository.findAll();
    }

    @Override
    public boolean backUpCustomers() {
        try{
            List<Customer> customerList = customerService.listAllCustomers();
            customerList.forEach(customer -> {
                CustomerBackUp customerBackUp = new CustomerBackUp();
                customerBackUp.setId(0);
                customerBackUp.setName(customer.getName());
                customerBackUp.setName(customer.getName());
                customerBackUp.setTemp("auto");

                customerBackUpRepository.save(customerBackUp);
            });
            return true;
        }
        catch (Exception e){
            System.out.println("CustomerBackUpServiceImpl => backUpCustomers: error");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveAllCustomerBackUps(List<CustomerBackUp> customerBackUpList) {
        try{
            customerBackUpRepository.saveAll(customerBackUpList);
            return true;
        }
        catch (Exception e){
            System.out.println("CustomerBackUpServiceImpl => saveAllCustomerBackUps: error");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveCustomer(CustomerBackUp customerBackUp) {
        try{
            customerBackUpRepository.save(customerBackUp);
            return true;
        }
        catch (Exception e){
            System.out.println("CustomerBackUpServiceImpl => saveCustomer: error");
            e.printStackTrace();
            return false;
        }
    }


}
