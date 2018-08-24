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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn_to_be_updated=request.getParameter("isbn_to_be_updated");
		String isbn=request.getParameter("isbn");
		String name=request.getParameter("name");
		String publication=request.getParameter("publication");
		String author=request.getParameter("author");
		Book book=new Book(isbn,name,publication,author);
		BookDAOImpl bookDaoImpl=new BookDAOImpl();
		int result=bookDaoImpl.updateBook(book,isbn_to_be_updated);
		if(result>0) {
			String message=result+" row(s) affected";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("message", "Record not found/Error updating");
				RequestDispatcher dispatcher=request.getRequestDispatcher("update.jsp");
				dispatcher.forward(request, response);
			}
	}

}
