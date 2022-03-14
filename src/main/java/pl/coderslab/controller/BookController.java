package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @PostMapping(path = "/book")
    void save(@RequestParam String title, @RequestParam int rating, @RequestParam String description, @RequestParam Long publisherId) {

        Publisher publisher = publisherService.findById(publisherId);

        Book book = new Book();

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);

        publisher.getBooks().add(book);

        bookService.save(book);
    }

    @GetMapping(path = "/book/{id}")
    String findById(@PathVariable Long id) {

        Book book = bookService.findById(id);

        return Objects.nonNull(book) ? book.toString() : "Nie znaleziono książki o podanym id " + id;
    }

    @GetMapping(path = "/books", params = "!rating")
    String findAll() {

        List<Book> books = bookService.findAll();

        return books.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    @PutMapping(path = "/book/{id}")
    void update(@PathVariable Long id, @RequestParam String title, @RequestParam int rating, @RequestParam String description) {

        Book book = bookService.findById(id);

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        bookService.update(book);
    }

    @DeleteMapping(path = "/book/{id}")
    void deleteById(@PathVariable Long id) {

        bookService.deleteById(id);
    }

    @GetMapping(path = "/books", params = "rating")
    String findAllByRating(@RequestParam int rating) {

        List<Book> books = bookService.findAllByRating(rating);

        return books.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    @GetMapping(path = "/books/publisher")
    String findAllByPublisherIsNotNull() {

        List<Book> books = bookService.findAllByPublisherIsNotNull();

        return books.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    @GetMapping(path = "/books", params = "publisherId")
    String findAllByPublisher(@RequestParam Long publisherId) {

        Publisher publisher = new Publisher();
        publisher.setId(publisherId);

        List<Book> books = bookService.findAllByPublisher(publisher);

        return books.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    @GetMapping(path = "/books", params = "authorId")
    String findAllByAuthor(@RequestParam Long authorId) {

        Author author = new Author();
        author.setId(authorId);

        List<Book> books = bookService.findAllByAuthor(author);

        return books.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }
}
