package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping(path = "/validate")
    public String validate(Book book, Model model) {

        Set<ConstraintViolation<Book>> violations =
                validator.validate(book);

        if(!violations.isEmpty()) {

            model.addAttribute("violations", violations);

            return "failure";
        } else {
            return "success";
        }
    }
}