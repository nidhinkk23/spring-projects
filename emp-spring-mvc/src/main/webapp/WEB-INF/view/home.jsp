<%@page import="java.util.List"%>
<%@page import="com.tyss.empspringmvc.dto.EmployeeInfoBean"%>
<%
 EmployeeInfoBean bean = (EmployeeInfoBean)session.getAttribute("bean");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="./change-password">Change Password</a>
	<a href="./logout" style="float: right;">Logout</a>
	<h1>
		Welcome<%=bean.getName()%></h1>

	 <%
		if (bean.getRole().equals("ADMIN")) {
	%>
	<a href="./register">Add Employee</a>
	<%
		}
	%> 

	<form action="./search">
	
		<input type="text" name="name" placeholder="Enter the name">
		<input type="submit" value="Search" placeholder="Search">
	</form>
	 <%
		List<EmployeeInfoBean> beans = (List<EmployeeInfoBean>)request.getAttribute("beans");
	%>
	
	<%
		if(beans !=  null){
		if(beans.isEmpty()){
	
	%>
	
	<h3>Data Not Found for the Given Name</h3>
	<%
		}else{
	%>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Mobile</td>
			<td>Role</td>
		</tr>
		
		<%for(EmployeeInfoBean infoBean : beans){ %>
			<tr>
			<td><%=infoBean.getName()%></td>
			<td><%=infoBean.getEmail()%></td>
			<td><%=infoBean.getMobile()%></td>
			<td><%=infoBean.getRole()%></td>
		</tr>
		<%} %>
		
	</table>
	
	<%
		}
		}
	%>
	
	
	
</body>
</html>