package com.dao;

import java.util.List;

import com.beans.Book;

public interface BookDAO {
	boolean addBook(Book book);
	int updateBook(Book book, String isbn);
	int deleteBook(String isbn);
	Book findBookById(String isbn);
	List<Book> findBooksByName(String name);
	List<Book> findAllBooks();
	List<Book> findBooksByAuthor(String author);
}
