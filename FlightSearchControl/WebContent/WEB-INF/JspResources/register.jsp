<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
	<h1>Login</h1>
	<br>
		<form method="post" action="register">
			<div class="form-group">
				<label for="fullName">Full Name: *</label> <input type="text"
					class="form-control" name="name" placeholder="Full Name" required>
				<form:errors path="registerDetails.name" />
			</div>

			<div class="form-group">
				<label for="username">Username: *</label> <input type="text"
					class="form-control" name="userId" required>
				<form:errors path="registerDetails.userId" />
			</div>

			<div class="form-group">
				<label for="email">Email: *</label> <input class="form-control"
					name="email" type="email" required>
				<form:errors path="registerDetails.email" />

			</div>


			<div class="form-group">
				<label for="email">password: *</label> <input class="form-control"
					name="pass" type="password" required>
				<form:errors path="registerDetails.pass" />
			</div>
			<a href="login">Existing User</a> <!-- <input type="submit"
				value="Register"><br> -->
				<button type="submit" class="btn btn-primary" value="register">Submit</button>
		</form>
	</div>
	<p>${InvalidationMsg}</p>


</body>
</html>