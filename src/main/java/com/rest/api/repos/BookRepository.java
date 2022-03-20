package com.rest.api.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.rest.api.entities.Book;

public interface BookRepository extends CrudRepository<Book, UUID>{
}
