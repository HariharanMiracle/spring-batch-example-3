package com.darkdevil.springbatchexample3.repository;

import com.darkdevil.springbatchexample3.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer WHERE `name` NOT IN (SELECT `name` FROM customer_back_up)", nativeQuery = true)
    public List<Customer> listAllCustomersNotInCustomerBackUp();
}
