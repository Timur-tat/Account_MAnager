package com.example.data.Servise;

import com.example.data.keys.Book;
import com.example.data.keys.BookId;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class BookServise {
    @PersistenceContext
EntityManager em;
    @CacheEvict(value = "name", key = "#book.bookId")
    @Cacheable(value = "name", key = "#book.bookId")
    @Transactional
    public Book updateBookCache(Book book) {
        // Метод для обновления записи в кеше.
        em.merge(book); // Обновление данных в базе данных
        return book; // Возвращает обновленную запись, чтобы она снова кешировалась
    }
    @Transactional
    @CacheEvict(value = "name", allEntries = true)
    public void clearCache() {
        // Метод для очистки всех записей из кеша.
        System.out.println("Cache cleared!");
    }
    @CachePut(value = "name", key = "#book.bookId")
    @Transactional
    public Book saveOrUpdateBook(Book book) {
        // Сохраняем или обновляем объект в базе данных
        return em.merge(book);
    }
    // Поиск всех книг с использованием Criteria API
    @Cacheable("name")
    @Transactional
    public List<Book> findAllBooks() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        query.select(root);

        List<Book> books = em.createQuery(query).getResultList();
        return books;
    }

    // Поиск книг по автору с использованием Criteria API
    @Transactional
  //  @Cacheable("name")
    public List<Book> findBooksByAuthor(String authorName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        // Условие: author = authorName
        query.select(root)
                .where(cb.equal(root.get("name"), authorName));

        return em.createQuery(query).getResultList();
    }
    // Поиск книги по составному ключу BookId
    @Transactional
    public Book findBookById(String title, String language) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        // Создаем условие поиска: BookId.title = title AND BookId.language = language
        query.select(root)
                .where(
                        cb.equal(root.get("bookId").get("title"), title),
                        cb.equal(root.get("bookId").get("language"), language)
                );

        return em.createQuery(query).getResultStream().findFirst().orElse(null);
    }
    // Поиск книг, название которых содержит определённую строку
    @Transactional
    public List<Book> findBooksByTitleLike(String titlePart) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        // Условие: BookId.title LIKE %titlePart%
        query.select(root)
                .where(cb.like(root.get("bookId").get("title"), "%" + titlePart + "%"));

        return em.createQuery(query).getResultList();
    }
    // Поиск книги по объекту BookId
    @Transactional
    public Book findBookByBookId(BookId bookId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        // Условия: bookId.title = bookId.getTitle() AND bookId.language = bookId.getLanguage()
        query.select(root)
                .where(
                        cb.equal(root.get("bookId").get("title"), bookId.getTitle()),
                        cb.equal(root.get("bookId").get("language"), bookId.getLanguage())
                );

        return em.createQuery(query).getResultStream().findFirst().orElse(null);
    }
    // Создание новой записи
    @Transactional
    public void createBook(String title, String language, String author) {
        //em.getTransaction().begin();
        BookId bookId = new BookId(title, language);
        Book book = new Book(bookId, author);
        em.persist(book);
      //  em.getTransaction().commit();
    }
    @Transactional
    public void createBook(Book book) {
       // em.getTransaction().begin();
        em.persist(book);
      //  em.getTransaction().commit();
    }

    // Удаление книги
    @Transactional
    public void deleteBook(String title, String language) {
        em.getTransaction().begin();
        BookId bookId = new BookId(title, language);
        Book book = em.find(Book.class, bookId);
        if (book != null) {
            em.remove(book);
        }
        em.getTransaction().commit();
        em.close();
        book.setName("Книга2");
    }

}
