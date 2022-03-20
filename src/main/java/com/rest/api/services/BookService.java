package com.rest.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entities.Book;
import com.rest.api.repos.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;

	public List<Book> getBooks() {
		return (List<Book>) this.bookRepo.findAll();
	}

	public Book getById(UUID id) {
		Optional<Book> book = this.bookRepo.findById(id);
		if (book.isEmpty()) {
			return null;
		}
		return book.get();
	}

	public Boolean deleteById(UUID id) {
		try {
			this.bookRepo.deleteById(id);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	public Book updateById(UUID id, Book newBook) {
		return this.bookRepo.save(newBook);
	}

	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
}
