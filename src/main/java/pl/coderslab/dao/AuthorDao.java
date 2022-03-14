package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Author addAuthor(String firstName, String lastName) {

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        entityManager.persist(author);

        return author;
    }

    public Author updateAuthor(long authorId, String newFirstName, String newLastName) {

        Author author = entityManager.find(Author.class, authorId);
        author.setFirstName(newFirstName);
        author.setLastName(newLastName);

        return entityManager.merge(author);
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select a from Author a");
        return query.getResultList();
    }

    public Author removeAuthor(long id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            entityManager.remove(author);
        }

        return author;
    }
}
