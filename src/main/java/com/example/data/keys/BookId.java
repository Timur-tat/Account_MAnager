package com.example.data.keys;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Embeddable
public class BookId implements Serializable {
    private String title;
    private String language;

    // default constructor

    public BookId(String title, String language) {
        this.title = title;
        this.language = language;
    }

    // getters, equals() and hashCode() methods
}