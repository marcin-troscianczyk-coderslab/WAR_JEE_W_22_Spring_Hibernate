package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.Collection;
import java.util.List;

@Controller
class BookFormController {

    private final PublisherService publisherService;

    private final BookService bookService;

    public BookFormController(PublisherService publisherService, BookService bookService) {
        this.publisherService = publisherService;
        this.bookService = bookService;
    }

    @GetMapping(path = "/form/book")
    String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping(path = "/form/book")
    String processAddForm(Book book) {
        bookService.save(book);
        return "redirect:/form/books";
    }

    @GetMapping(path = "/form/books")
    String showAllBooks(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        return publisherService.findAll();
    }
}
