package com.jpa.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	private String firstName;
	private String lastName;
	private String langauge;
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private  Book  book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getAuthorId() {
		return authorId;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", langauge="
				+ langauge + "]";
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authorId, String firstName, String lastName, String langauge) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.langauge = langauge;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}
	
	

}
