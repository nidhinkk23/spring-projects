package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");


		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Name");
		out.println(name);
		out.println("</h1>");
		out.println("<h1>Email");
		out.println(email);
		out.println("</h1>");
		out.println("<h1>Password");
		out.println(password);
		out.println("</h1>");
		out.println("<h1>Mobile");
		out.println(mobile);
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
