package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		if(email.equals("nidhinkk8@gmail.com")&& password.equals("123")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("sess-attr", new Object());
			out.println("<h1>Login Successfull</h1>");
			
		}else {
			HttpSession session = req.getSession(false);
			out.println("<h1>Invalid credentiall</h1>");
		}
		out.println("</html></body>");		
	}
}
