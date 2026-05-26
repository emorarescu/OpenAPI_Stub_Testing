package org.example.api;

import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class BookRepository {


    public Book findById(long id) {
        return new Book();
    }

    public Collection<Book> getBooks() {
        return new ArrayList<>();
    }

}
