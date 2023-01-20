package com.exampleMVC.MVC.repositories;

import com.exampleMVC.MVC.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
