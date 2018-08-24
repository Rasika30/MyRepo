package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Book;
import com.dao.BookDAOImpl;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		String name=request.getParameter("name");
		String publication=request.getParameter("publication");
		String author=request.getParameter("author");
		Book book=new Book(isbn,name,publication,author);
		BookDAOImpl bookDaoImpl=new BookDAOImpl();
		boolean result=bookDaoImpl.addBook(book);
		if(result==false) {
			request.setAttribute("message", "BOOK ADDED SUCCESSFULLY!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "ERROR ADDING BOOK");
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}
	}

}
