package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
class BookFormController {

    private final PublisherService publisherService;
    private final AuthorService authorService;

    private final BookService bookService;

    public BookFormController(PublisherService publisherService, AuthorService authorService, BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping(path = "/form/book")
    String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping(path = "/form/book")
    String processAddForm(@Valid Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "book/add";
        }
        bookService.save(book);
        return "redirect:/form/books";
    }

    @GetMapping(path = "/form/books")
    String showAllBooks(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "form/book/edit")
    String showEditForm(@RequestParam("id") Long bookId, Model model) {
        Optional<Book> book = bookService.findById(bookId);

        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        } else {
            model.addAttribute("notfound", true);
        }
        return "book/edit";
    }

    @PostMapping(path = "form/book/edit")
    String processEditForm(Book book) {
        bookService.update(book);
        return "redirect:/form/books";
    }

    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    Collection<Author> findAllAuthors() {
        return authorService.findAll();
    }
}
