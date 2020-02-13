<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

 <%@include file="/index.html" %> 
<%@page errorPage="error.jsp" %> 
<%@page isThreadSafe="false" %> 
<%@page session="false" %>
<html>
<%!
	private int i =10;
%>
<body>

<%
	Date date = new Date();
	printName();
	/* System.out.println(1/0); */
%>
<h1 style="color: pink;"><%=date %></h1>
<h1 style="color: red;">Value <%=i %></h1>
<h1><%= name %></h1>

</body>
</html>
<%!
	String name = "Arjun";
	public void printName(){
		System.out.println("inside method"+name);
	}
%>
<%!
	public void jspInit(){
	System.out.println("Init method");
	}
%>
<%!
	public void jspDestroy(){
	System.out.println("Destroy method");
	}
%>