package com.boot.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.restapi.dao.BookRepository;
import com.boot.restapi.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//Get All Books
	
	public List<Book> getAllBooks(){	
		
		                  // it returns Iterable which is a Parent Interface of all the List, 
		                  // so we can type cast Iterable to List
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		
		return list;	
	}
	
	//Get Single BookById
	
	public Book getBookById(int id) {		
		Book book = null;		
		try {
			book = this.bookRepository.findById(id);
		} 		
		catch (Exception e) {
			e.printStackTrace();
		}		
		return book;		
	}
	
	// Add Books
	
	public Book addBook(Book b) {
		Book result= bookRepository.save(b);
		return result;
	}
	
	
	// Delete Books
	
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
	
	//Update the Book
	
	public void updateBook(Book book, int bid) {
		
		book.setId(bid);		
		bookRepository.save(book);
		
	}
	
	

}

