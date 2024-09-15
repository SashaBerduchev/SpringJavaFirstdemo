package com.berduchev.springprogectfirst.controller;


import com.berduchev.springprogectfirst.model.Books;
import com.berduchev.springprogectfirst.model.Car;
import com.berduchev.springprogectfirst.services.BookService;
import com.berduchev.springprogectfirst.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("books")
public class BooksController {
    
    private BookService bookService;
    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    public String getAllBooks(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        try {

            List<Books> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            System.out.println(this);
            System.out.println(books);
            return "books/books";
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
