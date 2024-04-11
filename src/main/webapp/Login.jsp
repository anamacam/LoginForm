<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login Form</title>
</head>
<body>
	<h1 align="center">Student Login Form</h1>
	<form action="Login" method="post">
		<div align="center">
			<label>UserName: <input type="text" id="userName"
				name="userName"></label>
		</div>
		<br>
		<div align="center">
			<label>Password: <input type="text" id="password"
				name="password"></label>
		</div>
		<br>
		<div align="center">
			<input type="submit" value="login">
		</div>
	</form>
</body>
</html>