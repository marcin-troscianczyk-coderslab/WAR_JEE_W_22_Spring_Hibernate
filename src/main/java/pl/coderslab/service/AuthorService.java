package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Transactional
    public Author save(String firstName, String lastName) {

        return authorDao.addAuthor(firstName, lastName);
    }

    @Transactional
    public Author findById(Long authorId) {
        return authorDao.findById(authorId);
    }

    @Transactional
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Transactional
    public Author update(Long authorId, String newFirstName, String newLastName) {
        return authorDao.updateAuthor(authorId, newFirstName, newLastName);
    }

    @Transactional
    public Author deleteById(Long authorId) {
        return authorDao.removeAuthor(authorId);
    }
}
