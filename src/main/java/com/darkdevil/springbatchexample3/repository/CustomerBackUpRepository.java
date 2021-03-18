package com.darkdevil.springbatchexample3.repository;

import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBackUpRepository extends CrudRepository<CustomerBackUp, Integer> {
}
