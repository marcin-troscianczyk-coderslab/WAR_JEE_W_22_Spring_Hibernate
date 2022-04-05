package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Category;

public class StringToCategoryConverter implements Converter<String, Category> {

    @Override
    public Category convert(String source) {

        try {

            long categoryId = Long.parseLong(source);

            Category category = new Category();
            category.setId(categoryId);

            return category;
        } catch (NumberFormatException e) {

        }
        return null;
    }
}
