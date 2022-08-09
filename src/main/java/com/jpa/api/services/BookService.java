package com.jpa.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.api.dao.BookRepository;
import com.jpa.api.entities.Book;

@Component
public class BookService {
	//private static List<Book> list = new ArrayList<>();

	//static {
	//	list.add(new Book(12, "java complete referance", "XYZ"));

		//list.add(new Book(13, "java complete tut", "ABC"));

		//list.add(new Book(14, "Thiings in java", "LMN"));

	//}
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> list=(List<Book>) bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			
		//	book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;

	}

	// addding the book
	public Book addBook(Book b) {
		//list.add(b);
		Book result=bookRepository.save(b);
		return b;
	}

	// delete book
	public void deleteBook(int b) {

		//list.stream().filter(e -> e.getId() != b).collect(Collectors.toList());
		bookRepository.deleteById(b);
	}

	// update th e book
	public void upadateBook(Book book, int bookId) {

//		list = list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
	}
}
