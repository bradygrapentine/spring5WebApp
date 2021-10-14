package com.bradygrapentinefirstspringapp.spring5WebApp.repositories;

import com.bradygrapentinefirstspringapp.spring5WebApp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    // Spring Data JPA provides the implementation of this interface
}
