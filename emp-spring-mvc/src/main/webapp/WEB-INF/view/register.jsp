<%@page session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a href="./home">Home</a>
		<a href="./logout" style="float: right;">Logout</a>
			<form action="./register" method="post">
				<table>
					
					<tr>
						<td>${msg}</td>
						
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="email" name="email"></td>
					</tr>
					<tr>
						<td>Mobile number:</td>
						<td><input type="number" name="mobile"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><select name="role">
								<option value="ADMIN">Admin</option>
								<option value="USER">User</option>
						</select></td>
					</tr>

					<tr>

						<td><input type="submit" value="Register"></td>
					</tr>

				</table>

			</form>
</body>
</html>