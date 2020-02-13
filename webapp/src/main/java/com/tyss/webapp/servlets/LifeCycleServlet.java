package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet({"/life-cycle","/life/cycle","/life-cycle.html","*.php"})
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet(){
		System.out.println("Object Created");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Service");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
