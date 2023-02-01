package com.springcourse.project2Boot.util;

import com.springcourse.project2Boot.models.Book;
import com.springcourse.project2Boot.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    private final BooksService booksService;

    @Autowired
    public BookValidator(BooksService booksService) {
        this.booksService = booksService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;

        if (booksService.findByTitleAndAuthor(book.getTitle(), book.getAuthor()).isPresent()) {
            errors.rejectValue("title", "", "Книга с таким именем и автором уже зарегистрирована");
            errors.rejectValue("author", "", "Книга с таким именем и автором уже зарегистрирована");
        }
    }
}
