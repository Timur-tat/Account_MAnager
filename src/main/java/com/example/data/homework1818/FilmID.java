package com.example.data.homework1818;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class FilmID implements Serializable {
    private String genre;
    private int year_exit;
    public FilmID(String genre, int year_exit) {
        this.genre = genre;
        this.year_exit = year_exit;
    }

}
