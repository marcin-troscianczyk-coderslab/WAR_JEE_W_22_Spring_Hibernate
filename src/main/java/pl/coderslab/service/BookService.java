package pl.coderslab.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllByRating(int rating) {
        return bookRepository.findAllByRating(rating);
    }

    public List<Book> findAllByPublisherIsNotNull() {
        return bookRepository.findAllByPublisherIsNotNull();
    }

    public List<Book> findAllByPublisher(Publisher publisher) {
        return bookRepository.findAllByPublisher(publisher);
    }

    public List<Book> findAllByAuthor(Author author) {
        return bookRepository.findAllByAuthors(author);
    }

    public List<Book> findAllByTitleUsingQuery(String title) {
        return bookRepository.findAllByTitleUsingQuery(title);
    }

    public List<Book> findAllByCategoryUsingQuery(Category category) {
        return bookRepository.findAllByCategoryUsingQuery(category);
    }

    public List<Book> findAllByRatingBetween(int start, int stop) {
        return bookRepository.findAllByRatingBetween(start, stop);
    }
}
