package com.darkdevil.springbatchexample3.batch;

import com.darkdevil.springbatchexample3.Constant;
import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<CustomerBackUp, CustomerBackUp> {

    @Override
    public CustomerBackUp process(CustomerBackUp customerBackUp) throws Exception {
        String auto = Constant.AUTO;
        System.out.println("Converted from: " + customerBackUp);
        customerBackUp.setTemp(auto);
        System.out.println("Converted to: " + customerBackUp);
        return customerBackUp;
    }
}
