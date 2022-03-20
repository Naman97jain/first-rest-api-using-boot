package com.rest.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entities.Book;
import com.rest.api.services.BookFakeService;
import com.rest.api.services.BookService;

@RestController
public class BookControllers {
	
	@Autowired
	private BookService bookService;
	
//	@GetMapping("/books")
//	public List<Book> getBooks(){
//		return this.bookService.getBooks();
//	}
	
	//If you want to send status code to the client then 
	//make use of Response Entity.
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books = this.bookService.getBooks();
		if(books.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(books));
	}
	
//	@GetMapping("/book/{id}")
//	public Book getBookById(@PathVariable("id") int id) {
//		return this.bookService.getById(id);
//	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") UUID id){
		Book book = this.bookService.getById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		return this.bookService.createBook(book);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBookById(@PathVariable("id") UUID id, @RequestBody Book newBook) {
		return this.bookService.updateById(id, newBook);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable("id") UUID id) {
		Boolean deleteResult = this.bookService.deleteById(id);
		if (!deleteResult) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
