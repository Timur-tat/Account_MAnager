package com.example.data.Reps;

import com.example.data.Entity.BaseEntity;
import com.example.data.keys.Book;
import com.example.data.keys.BookId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseEntityRep extends CrudRepository<Book, BookId> {
    List<Book> findBookByBookId(BookId bookId);
}
