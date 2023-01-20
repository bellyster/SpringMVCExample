package com.exampleMVC.MVC.bootstrap;

import com.exampleMVC.MVC.domain.Author;
import com.exampleMVC.MVC.domain.Book;
import com.exampleMVC.MVC.domain.Publisher;
import com.exampleMVC.MVC.repositories.AuthorRepository;
import com.exampleMVC.MVC.repositories.BookRepository;
import com.exampleMVC.MVC.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author colfer = new Author("Eoin", "Colfer");
        Book book1 = new Book("Artemis Fowl", "ISBN1321");

        colfer.getBooks().add(book1);
        book1.getAuthors().add(colfer);

        authorRepository.save(colfer);
        bookRepository.save(book1);

        Author king = new Author("Stephen", "King");
        Book book2 = new Book("The long walk", "ISBN12421");

        king.getBooks().add(book2);
        book2.getAuthors().add(king);

        authorRepository.save(king);
        bookRepository.save(book2);

        Publisher salamandra = new Publisher("Salamandra", "España");
        salamandra.getBooks().add(book2);
        salamandra.getBooks().add(book1);
        book1.setPublisher(salamandra);
        book2.setPublisher(salamandra);
        publisherRepository.save(salamandra);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
