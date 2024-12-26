package com.example.data.Reps;

import com.example.data.keys.Book;
import org.springframework.data.repository.CrudRepository;
public interface BookRep extends CrudRepository<Book, Integer> {
}
