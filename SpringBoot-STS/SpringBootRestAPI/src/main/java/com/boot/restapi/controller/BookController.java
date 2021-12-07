package com.boot.restapi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.boot.restapi.entities.Book;
import com.boot.restapi.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	//get all books handler
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> list = bookService.getAllBooks();
		if(list.size() <= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);		
	}
	
	
	//Get a single book handler
	
	@GetMapping("/books/{bid}")
	public ResponseEntity<Book> getBook(@PathVariable("bid") int id) {
		
		Book book = bookService.getBookById(id);
		if(book==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));	
	}
	
	
	// add book handler
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		try {
			bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	//Delete book handler
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bid){
		
		try {
			bookService.deleteBook(bid);
			return ResponseEntity.noContent().build();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}		
		
	}
	
	
	// Update Book Handler
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bid) {
		
		try {
			bookService.updateBook(book, bid);
			return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	

}
