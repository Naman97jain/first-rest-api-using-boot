package com.rest.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rest.api.entities.Book;

@Service
public class BookFakeService {
//	private static List<Book> books = new ArrayList<Book>();
//
//	static {
//		books.add(new Book(1, "Java Complete Reference", 400, "ABC"));
//		books.add(new Book(2, "Java Spring", 600, "DEF"));
//		books.add(new Book(3, "Java Spring Boot", 800, "GHI"));
//	}
//
//	public List<Book> getBooks() {
//		return books;
//	}
//
//	public Book getById(int id) {
//		Book book = null;
//		try {
//			book = books.stream().filter(b -> b.getId() == id).findFirst().get();
//		} catch (NoSuchElementException ex) {
//			ex.printStackTrace();
//		}
//		return book;
//	}
//
//	public Book updateBookById(int id, Book newBook) {
//		books = books.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setName(newBook.getName());
//				b.setAuthor(newBook.getAuthor());
//				b.setPrice(newBook.getPrice());
//			}
//			return b;
//		}).collect(Collectors.toList());
//		return this.getById(id);
//
//	}
//
//	public Book deleteById(int id) {
//		Book bookToBeRemoved = this.getById(id);
//		Boolean isRemoved = books.remove(bookToBeRemoved);
//		if (isRemoved) {
//			return bookToBeRemoved;
//		}
//		return null;
//	}
//
//	public Book createBook(Book book) {
//		books.add(book);
//		return book;
//	}
}
