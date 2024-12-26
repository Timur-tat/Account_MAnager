package com.example.data.Reps;

import com.example.data.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRep extends CrudRepository<Product, Integer> {
}
