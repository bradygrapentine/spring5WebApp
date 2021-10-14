package com.bradygrapentinefirstspringapp.spring5WebApp.repositories;

import com.bradygrapentinefirstspringapp.spring5WebApp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    // Spring Data JPA provides the implementation of this interface
}
