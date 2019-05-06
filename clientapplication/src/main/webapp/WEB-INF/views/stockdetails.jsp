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
<h2 class="w3-green" align="center">STOCK DETAILS</h2>

	<table border="1" align="center" class="w3-table-all w3-container">
		<tr class="w3-black">
		<th>Id</th>
			<th>MANUFACTURER</th>
			<th>QUANTITY</th>
			<th>ADDED DATE</th>
			<th>COST PRICE PER PRODUCT</th>
			<th>SELLING PRICE</th>
			<th>DISCOUNT</th>
			<th>GST</th>
		</tr>
		<c:forEach items="${stockdetails}" var="stockdetails">
			<tr>
			<td>${stockdetails.getId()}</td>
				<td>${stockdetails.getManufacturer()}</td>
				<td>${stockdetails.getQuantity()}</td>
				<td>${stockdetails.getDate()}</td>
				<td>${stockdetails.getCostPrice()}</td>
				<td>${stockdetails.getSellingPrice()}</td>
				<td>${stockdetails.getDiscount()}</td>
				<td>${stockdetails.getGst()}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	
	<%@include file="manager-fragments/footer.jsp"%>
</body>
</html>