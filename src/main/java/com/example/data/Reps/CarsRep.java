package com.example.data.Reps;

import com.example.data.Entity.SingleTable.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsRep extends CrudRepository<Cars, Integer> {
}
