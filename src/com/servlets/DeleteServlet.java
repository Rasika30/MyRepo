package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAOImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		BookDAOImpl bookDaoImpl=new BookDAOImpl();
		int result=bookDaoImpl.deleteBook(isbn);
		if(result>0) {
		String message=result+" row(s) affected";
		request.setAttribute("message", message);
		RequestDispatcher dispatcher=request.getRequestDispatcher("delete.jsp");
		dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "Record not found");
			RequestDispatcher dispatcher=request.getRequestDispatcher("delete.jsp");
			dispatcher.forward(request, response);
		}
	}

}
