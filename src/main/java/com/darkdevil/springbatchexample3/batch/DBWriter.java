package com.darkdevil.springbatchexample3.batch;

import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import com.darkdevil.springbatchexample3.service.CustomerBackUpService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<CustomerBackUp> {

    @Autowired
    private CustomerBackUpService customerBackUpService;


    @Override
    public void write(List<? extends CustomerBackUp> list) throws Exception {
        System.out.println("Data backed up: " + list);
        customerBackUpService.saveAllCustomerBackUps((List<CustomerBackUp>) list);
    }
}
