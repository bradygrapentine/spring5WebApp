package com.bradygrapentinefirstspringapp.spring5WebApp.repositories;

import com.bradygrapentinefirstspringapp.spring5WebApp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    // Spring Data JPA provides the implementation of this interface
}
