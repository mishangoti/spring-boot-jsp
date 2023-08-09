package com.jpa.test.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.book.dao.BookRepository;
import com.jpa.test.book.entities.Book;

@Service
public class BookService {
	
	// fake service
	//	private static List<Book> list = new ArrayList<>();
	//	
	//	static {
	//		list.add(new Book(12, "Java Spring", "mishan"));
	//		list.add(new Book(13, "Java Spring Boot", "xyz"));
	//		list.add(new Book(14, "Python Spring Django", "goti"));
	//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		// fake service
		// return list;
		
		// using BookService JPA
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getBooksById(int id) {
		// fake service
		//		Book book = null;
		//		try {
		//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//		return book;
		
		// using BookService JPA
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		// fake service
		//		list.add(book);
		//		return book;
		
		// using BookService JPA
		Book result = bookRepository.save(book);
		return result;
	}
	
	public void deleteBook(int id) {
		// fake service
		//		list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
		
		// using BookService JPA
		this.bookRepository.deleteById(id);
	}

	public void updateBook(Book book, int bookId) {
		// fake service
		//		list = list.stream().map(b-> {
		//		if(b.getId()==bookId) {
		//			b.setTitle(book.getTitle());
		//			b.setAuthor(book.getAuthor());
		//			b.setTitle(book.getTitle());
		//		}
		//		return b;
		//	}).collect(Collectors.toList());
		
		// using BookService JPA
		book.setId(bookId);
		bookRepository.save(book);
	}
}
