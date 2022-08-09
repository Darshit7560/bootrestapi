package com.jpa.api.controllers;

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

import com.jpa.api.entities.Book;
import com.jpa.api.services.BookService;

//@Controller
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// @RequestMapping(value="/books",method=RequestMethod.GET)

	// get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// get one book by id
	@GetMapping("/books/{bookid}")
	public ResponseEntity<Book> getBookBYId(@PathVariable("bookid") int bookid) {

		Book book = bookService.getBookById(bookid);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// crete book
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// delete book handler
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Object> deleteBook(@PathVariable("bookid") int bookid) {

		try 
		{
			this.bookService.deleteBook(bookid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// update book handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookService.upadateBook(book, bookId);
		return book;
	}

}

