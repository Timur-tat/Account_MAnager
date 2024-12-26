package com.example.data.keys;

import jakarta.persistence.Cacheable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable @org.hibernate.annotations.Cache(usage =
        CacheConcurrencyStrategy.READ_WRITE)
public class Book {
    @EmbeddedId
    private BookId bookId;
    private String name;

    // constructors, other fields, getters and setters
}