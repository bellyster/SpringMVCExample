package com.exampleMVC.MVC.repositories;

import com.exampleMVC.MVC.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
