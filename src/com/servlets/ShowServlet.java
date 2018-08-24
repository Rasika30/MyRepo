package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Book;
import com.dao.BookDAOImpl;

@WebServlet("/showall")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAOImpl bookDaoImpl=new BookDAOImpl();
		List<Book> list=(ArrayList<Book>)bookDaoImpl.findAllBooks();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
	}

}
