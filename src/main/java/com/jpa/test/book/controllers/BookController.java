package com.jpa.test.book.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.book.entities.Book;
import com.jpa.test.book.services.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// get all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	// get single book
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") int bookId) {
		Book book = this.bookService.getBooksById(bookId);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	// add new book
	@PostMapping("/books") 
	public ResponseEntity<Book> addBooks(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// delete single book
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookService.deleteBook(bookId);
			// return ResponseEntity.ok().build();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// update existing book
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		try {
			this.bookService.updateBook(book, bookId);	
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
