package com.exampleMVC.MVC.controllers;

import com.exampleMVC.MVC.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //URL MAPPING
    @RequestMapping("/authors")
    public String listAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
}
