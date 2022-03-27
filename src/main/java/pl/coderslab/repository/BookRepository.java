package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByRating(int rating);
    List<Book> findAllByPublisherIsNotNull();
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByAuthors(Author author);
}
