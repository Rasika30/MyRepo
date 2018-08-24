package com.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.beans.Book;
import com.connection.MyConnection;

public class BookDAOImpl implements BookDAO{
	boolean result;
	@Override
	public boolean addBook(Book book) {
		
		try {
			String INSERT_BOOK="insert into Books values(?,?,?,?);";
			PreparedStatement preparedStatement=MyConnection.getMyConnection().prepareStatement(INSERT_BOOK);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getName());
			preparedStatement.setString(3, book.getPublication());
			preparedStatement.setString(4, book.getAuthor());
			result=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateBook(Book book, String isbn){
		int rows=0;
		try {
		String UPDATE_BOOK_BY_ID="update Books set name=? where isbn=?";
		PreparedStatement preparedStatement= MyConnection.getMyConnection().prepareStatement(UPDATE_BOOK_BY_ID);
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, isbn);
		rows=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int deleteBook(String isbn) {
		int rows=0;
		try {
		String DELETE_BOOK_BY_ISBN="delete from Books where isbn=?";
		PreparedStatement preparedStatement;
		preparedStatement = MyConnection.getMyConnection().prepareStatement(DELETE_BOOK_BY_ISBN);
		preparedStatement.setString(1, isbn);
		rows=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public Book findBookById(String isbn) {
		Book book = new Book();
		try {
		String FIND_BOOK_BY_ID="select * from Books where isbn=?";
		PreparedStatement preparedStatement;
		preparedStatement = MyConnection.getMyConnection().prepareStatement(FIND_BOOK_BY_ID);	
		preparedStatement.setString(1, isbn);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			book=new Book(rs.getString("isbn"),rs.getString("name"),rs.getString("publication"),rs.getString("author"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> findBooksByName(String name) {
		List<Book> books = new ArrayList<>();
		Book book;
		try {
		String FIND_BOOK_BY_NAME="select * from Books where name=?";
		PreparedStatement preparedStatement;
		preparedStatement = MyConnection.getMyConnection().prepareStatement(FIND_BOOK_BY_NAME);	
		preparedStatement.setString(1, name);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			book=new Book(rs.getString("isbn"),rs.getString("name"),rs.getString("publication"),rs.getString("author"));
			books.add(book);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> findAllBooks() {
			List<Book> list=new ArrayList<>();
			try {
			ResultSet rs;
			String FIND_BOOKS="select * from Books;";
			Statement statement=MyConnection.getMyConnection().createStatement();
			rs=statement.executeQuery(FIND_BOOKS);
			while(rs.next()) {
				Book book=new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(book);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		List<Book> books = new ArrayList<>();
		Book book;
		try {
		String FIND_BOOK_BY_AUTHOR="select * from Books where author=?";
		PreparedStatement preparedStatement;
		preparedStatement = MyConnection.getMyConnection().prepareStatement(FIND_BOOK_BY_AUTHOR);	
		preparedStatement.setString(1, author);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			book=new Book(rs.getString("isbn"),rs.getString("name"),rs.getString("publication"),rs.getString("author"));
			books.add(book);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}
