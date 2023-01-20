package com.exampleMVC.MVC.repositories;

import com.exampleMVC.MVC.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
