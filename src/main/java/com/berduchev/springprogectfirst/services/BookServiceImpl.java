package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Override
    public List<Books> getAllBooks() {
        return List.of();
    }

    @Override
    public Books getBookById(int id) {
        return null;
    }

    @Override
    public Books createBook(Books book) {
        return null;
    }

    @Override
    public void deleteBook(int id) {

    }
}
