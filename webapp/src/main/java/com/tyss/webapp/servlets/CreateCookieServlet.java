package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/create-cookie")
public class CreateCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		Cookie cookie = new Cookie("name", "Anushka");
		cookie.setMaxAge(60*60*24*7);
		Cookie cookie1 = new Cookie("name1", "Kohli");
		resp.addCookie(cookie);
		resp.addCookie(cookie1);
		out.println("<html>"
				+"<body>"
				+"<h1>Cookie Created</h1>"
				+"</body>"
				+"</html>");
	
	}
}
