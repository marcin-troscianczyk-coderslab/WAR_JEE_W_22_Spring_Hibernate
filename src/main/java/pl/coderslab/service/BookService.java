package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book) {
        bookDao.save(book);
    }

    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void deleteById(Long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
    }

    public List<Book> findAllByRating(int rating) {
        return bookDao.findAllByRating(rating);
    }

    public List<Book> findAllByPublisherIsNotNull() {
        return bookDao.findAllByPublisherIsNotNull();
    }

    public List<Book> findAllByPublisher(Publisher publisher) {
        return bookDao.findAllByPublisher(publisher);
    }

    public List<Book> findAllByAuthor(Author author) {
        return bookDao.findAllByAuthor(author);
    }
}
