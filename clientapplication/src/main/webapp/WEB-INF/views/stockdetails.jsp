<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Details</title>
</head>

<h2 align="center">STOCK DETAILS</h2>
<body>
	<table border="1" align="center">
		<tr>
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
	<br>
	<br>
	<br>
</body>
</html>
