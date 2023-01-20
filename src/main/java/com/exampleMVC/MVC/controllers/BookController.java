package com.exampleMVC.MVC.controllers;

import com.exampleMVC.MVC.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Mapping de url.
    @RequestMapping("/books")
    public String listBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
