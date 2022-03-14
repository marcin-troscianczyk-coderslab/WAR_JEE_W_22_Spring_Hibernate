package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select b from Book b");
        return query.getResultList();
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating = :alamakota")
                .setParameter("alamakota", rating)
                .getResultList();
    }

    public List<Book> findAllByPublisherIsNotNull() {
        Query query =
                entityManager.createQuery("select b from Book b where b.publisher is not null");
        return query.getResultList();
    }

    public List<Book> findAllByPublisher(Publisher publisher) {
        Query query =
                entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> findAllByAuthor(Author author) {
        Query query =
                entityManager.createQuery("select b from Book b where :author member of b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
