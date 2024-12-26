package com.example.data.Servise;

import com.example.data.homework1818.Film;
import com.example.data.homework1818.FilmID;

import com.example.data.keys.Book;
import com.example.data.keys.BookId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class FilmService {
    @PersistenceContext
    EntityManager em;
    // Поиск всех фильмов с использованием Criteria API
    @Transactional
    public List<Film> findAllFilms() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> root = query.from(Film.class);

        query.select(root);

        List<Film> films = em.createQuery(query).getResultList();
        return films;
    }
    // Поиск книги по составному ключу FilmID
    @Transactional
    public Film findFilmID(String genre, int year_exit) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> root = query.from(Film.class);

        // Создаем условие поиска: FilmId.genre = genre AND FilmId.year_exit = year_exit
        query.select(root)
                .where(
                        cb.equal(root.get("FilmID").get("genre"), genre),
                        cb.equal(root.get("FilmID").get("year_exit"), year_exit)
                );

        return em.createQuery(query).getResultStream().findFirst().orElse(null);
    }
    // Поиск Фильмов, название которых содержит определённую строку
    @Transactional
    public List<Film> findFilmsByGenreLike(String genrePart) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> root = query.from(Film.class);

        // Условие: FilmId.title LIKE %titlePart%
        query.select(root)
                .where(cb.like(root.get("filmID").get("genre"), "%" + genrePart + "%"));

        return em.createQuery(query).getResultList();
    }
    // Создание новой записи
    @Transactional
    public void createFilm(String genre, int year_exit) {
        //em.getTransaction().begin();
        FilmID filmID = new FilmID(genre, year_exit);
        Film film = new Film(filmID,"сказка","Итальянский");
        em.persist(film);
        //  em.getTransaction().commit();
    }
}
