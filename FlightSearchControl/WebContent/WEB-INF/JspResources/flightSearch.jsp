<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
<style>
fieldset {
	background-color: #33D5FF;
	padding: 30px 25px;
	border: 10px groove(internal value);
}

legend {
	background-color: gray;
	color: white;
	padding: 5px 10px;
}

div {
	width: 350px;
	margin: auto;
	position: fixed;
	top: 30%;
	left: calc(50% - 175px);
}

form input {
	float: right;
	margin-right: 20px;
	border: 0.5px solid black;
}

p {
	/* margin:10px 20px 0px 0px; */
	font-size: small;
	float: right;
	color: red;
}

span {
	font-size: small;
	color: red;
}
</style>
</head>
<body style="background-color: #AFEDFC;">
	<a href="logout"><button>sign out</button> </a>
	<p>WELCOME ${loginedUser.userId}</p>
	<div>
		<fieldset>
			<legend>Flight Search Form</legend>
			<form method="post" action="flightSearch">
				<label>Departure Location <input name="depLoc" required></label>
				<form:errors path="flightdetails.depLoc" />
				<br> <br> <label>Arrival Location <input
					name="arrLoc" required></label>
				<form:errors path="flightdetails.arrLoc" />
				<br> <br> <label>Flight Date <input
					name="flightDate" type="date" required></label>
				<form:errors path="flightdetails.flightDate" />
				<br> <br> <label>Flight Class <input
					name="flightClass" required></label>
				<form:errors path="flightdetails.flightClass" />
				<br> <br> Output Preference :
				<form:errors path="flightdetails.outputPreference" />
				<br> <br> <label><input name="outputPreference"
					type="radio" value="1" required style="margin: 0px; float: none;">
					By Price </label> <label><input name="outputPreference"
					type="radio" value="2" required style="margin: 0px; float: none;">
					By Duration </label> <br> <br> <input type="submit"
					value="Search"><br>
			</form>
			<p>${flightSearchValidationMsg}</p>
		</fieldset>
	</div>

</body>
</html>