<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Manager</title>
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
<body class="w3-light-grey">

	<%@include file="manager-fragments/manager-nav.jsp"%>
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">


		<br>
		<form name="form1" class="w3-card-4 w3-margin w3-padding w3-container"
			action="/viewstockdetails">
			<h2 class="w3-center w3-green w3-border">View Stock</h2>
			<br> <label class="w3-text-large"><strong>Select
					Product Name</strong> </label> <select name="productId" class="w3-input w3-border">
				<c:forEach items="${productlist}" var="product">
					<option value="${product.getId()}">${product.getName()}</option>
				</c:forEach>
			</select> <br>
			<center>
				<input type="submit" class="w3-button w3-green w3-center"
					style="width: 150px;" value="View Stock " /> <br> <br>
					<a href="/manager"  type="Button" class="w3-button w3-green w3-center"
					style="width: 150px;" value="Home">HOME</a> <br> <br>
					
			</center>
			<br>
		</form>


		
	</div>
	<%@include file="manager-fragments/footer.jsp"%>


</body>
</html>