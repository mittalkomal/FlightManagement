<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login</h1>
		<br>

		<form action="login" method="post">
			<div class="form-group">
				<label for="username">UserName : </label><input class="form-control"
					name="userId" required>
				<form:errors path="loginDetails.userId" />
			</div>

			<div class="form-group">
				<label for="password">password : </label> <input name="pass"
					class="form-control" type="password" required>
				<form:errors path="loginDetails.pass" />
			</div>

			<br> <a href="register">Register User </a> <input type="submit"
				value="Login" id="loginSubmitBtn">
		</form>
	</div>
	<p>${InvalidationMsg}</p>


</body>
</html>