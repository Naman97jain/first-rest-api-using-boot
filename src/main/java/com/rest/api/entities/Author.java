package com.rest.api.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;

	private String name;
	private int reputation;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", reputation=" + reputation + "]";
	}

}
