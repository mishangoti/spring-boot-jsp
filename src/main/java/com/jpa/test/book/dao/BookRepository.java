package com.jpa.test.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
