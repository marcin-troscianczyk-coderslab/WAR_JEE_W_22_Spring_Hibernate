package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByRating(int rating);
    List<Book> findAllByPublisherIsNotNull();
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByAuthors(Author author);

    // zad 2a
    List<Book> findAllByTitle(String title);

    @Query("select b from Book b where b.title = :title")
    List<Book> findAllByTitleUsingQuery(@Param("title") String title);

    // zad 2b
    List<Book> findAllByCategory(Category category);

    @Query("select b from Book b where b.category = :category")
    List<Book> findAllByCategoryUsingQuery(@Param("category") Category category);

    // zad 2c
    List<Book> findAllBooksByCategoryId(long idCategory);

    // zad 3a
    List<Book> findAllBooksByAuthors(Author author);

    // zad 3b
    List<Book> findAllBooksByPublisher(Publisher publisher);

    // zad 3c
    List<Book> findAllBooksByRating(int rating);

    // zad 3d
    Optional<Book> findFirstBookByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findAllByRatingBetween(int start, int stop);

}
