<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Stock Book</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<style>
input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

.topnav-centered a {
	float: none;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>

<body class="w3-light-grey">

	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4"
		align="center">
		<span class="topnav-centered">Welcome To Stock Book</span> <span
			class="w3-bar-item w3-center"> Biller Page </span> <a href="#"
			class="w3-bar-item w3-button w3-padding"> <i
			class="fa fa-user-circle-o fa-fw"> </i>&nbsp; About me
		</a> <a href="/" class="w3-bar-item w3-right"><i
			class="fa fa-sign-out"></i>Logout</a>
	</div>
	<br>
	<br>

	<div id="tfheader" align="center">
		<form id="tfnewsearch" method="get" action="/search">
			<input type="text" class="tftextinput" name="productname" size="21"><input
				type="submit" value="search" class="tfbutton">
		</form>
		<div class="tfclear"></div>
	</div>
	<br>
	<br>
	<br>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>PRODUCT NAME</th>
			<th>CATEGORY ID</th>
			<th>DESCRIPTION</th>

		</tr>
		<c:forEach items="${listproducts}" var="department">
			<tr>
				<td>${department.getId()}</td>
				<td>${department.getName()}</td>
				<td>${department.getCategoryId()}</td>
				<td>${department.getDescription()}</td>

			</tr>
		</c:forEach>
	</table>

	<br />
</body>
</html>