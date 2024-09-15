package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Books;

import java.util.List;

public interface BookService {
    List<Books> getAllBooks();
    Books getBookById(int id);
    Books createBook(Books book);
    void deleteBook(int id);
}
