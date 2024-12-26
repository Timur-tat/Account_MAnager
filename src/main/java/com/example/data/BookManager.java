package com.example.data;

import com.example.data.keys.Book;
import com.example.data.keys.BookId;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.List;

public class BookManager {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BookManager() {
        this.emf = Persistence.createEntityManagerFactory("example-unit");
        this.em = emf.createEntityManager();
    }

    // Создание новой записи
    public void createBook(String title, String language, String author) {
        em.getTransaction().begin();
        BookId bookId = new BookId(title, language);
        Book book = new Book(bookId, author);
        em.persist(book);
        em.getTransaction().commit();
    }

    // Удаление книги
    public void deleteBook(String title, String language) {
        em.getTransaction().begin();
        BookId bookId = new BookId(title, language);
        Book book = em.find(Book.class, bookId);
        if (book != null) {
            em.remove(book);
        }
        em.getTransaction().commit();
    }

    // Поиск всех книг
    public List<Book> findAllBooks() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }

    // Поиск книг по автору
    public List<Book> findBooksByAuthor(String authorName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(cb.equal(root.get("author"), authorName));
        return em.createQuery(query).getResultList();
    }

    // Поиск книги по составному ключу
    public Book findBookById(String title, String language) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root)
             .where(
                 cb.equal(root.get("bookId").get("title"), title),
                 cb.equal(root.get("bookId").get("language"), language)
             );
        return em.createQuery(query).getResultStream().findFirst().orElse(null);
    }

    // Поиск книг, название которых содержит определённую строку
    public List<Book> findBooksByTitleLike(String titlePart) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root)
             .where(cb.like(root.get("bookId").get("title"), "%" + titlePart + "%"));
        return em.createQuery(query).getResultList();
    }

    // Поиск книг по языку
    public List<Book> findBooksByLanguage(String language) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root)
             .where(cb.equal(root.get("bookId").get("language"), language));
        return em.createQuery(query).getResultList();
    }

    // Закрытие EntityManager
    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}