package com.jpa.test.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpa.test.book.models.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12, "Java Spring", "mishan"));
		list.add(new Book(13, "Java Spring Boot", "xyz"));
		list.add(new Book(14, "Python Spring Django", "goti"));
	}
	
	public List<Book> getAllBooks() {
		return list;
	}
	
	public Book getBooksById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e->e.getId()==id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	public void deleteBook(int id) {
		list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
	}

	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b-> {
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
}
