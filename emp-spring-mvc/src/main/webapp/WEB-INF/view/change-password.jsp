<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a href="./home">Home</a>
		<a href="./logout">Logout</a>
		
		
	<form action="./change-password" method="post">
		<table>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="password" placeholder="Enter New Password"></td>
			</tr>
			<tr>
				<td>
					<td><input type="submit" value="Change Password"></td>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>