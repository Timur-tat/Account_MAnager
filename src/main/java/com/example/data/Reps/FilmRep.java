package com.example.data.Reps;

import com.example.data.homework1818.Film;
import com.example.data.homework1818.FilmID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRep extends CrudRepository<Film, FilmID> {
    List<Film> findFilmByFilmID(FilmID filmID);
}
