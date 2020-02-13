<%@page session="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./login" method="post">
		<table style="border: 20px;padding-top: 10%;padding-left: 40%">
			<tr>
				<td>${msg}</td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>

				<td><input type="submit" value="Login"></td>
			</tr>
			
		</table>	
	
	</form>
</body>
</html>