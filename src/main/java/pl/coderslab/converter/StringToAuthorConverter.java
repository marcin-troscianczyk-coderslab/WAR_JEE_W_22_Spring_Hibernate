package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Author;

public class StringToAuthorConverter implements Converter<String, Author> {

    @Override
    public Author convert(String source) {

        try {

            long authorId = Long.parseLong(source);

            Author author = new Author();
            author.setId(authorId);

            return author;
        } catch (NumberFormatException e) {

        }
        return null;
    }
}
