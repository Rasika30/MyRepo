package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.checkLogin(name, password)==1)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("admin_page.jsp");
			dispatcher.forward(request, response);
		}
		else if(loginDao.checkLogin(name, password)==2)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("user_page.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "CREDENTIALS NOT MATCHING");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			//login page is now reusable
		}
	}

}
