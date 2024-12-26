package com.example.data.Reps;

import com.example.data.Entity.SingleTable.Car1;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface Car1Rep extends CrudRepository<Car1, Integer>, JpaSpecificationExecutor<Car1> {
}
