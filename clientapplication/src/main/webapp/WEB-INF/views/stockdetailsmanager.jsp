<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
background-image:
 url("https://media.istockphoto.com/photos/supermarket-aisle-with-empty-green-shopping-cart-picture-id817240836?k=6&m=817240836&s=612x612&w=0&h=I_77CJZV_tl3kdN-R1yav7jIa4lOs4JgqZZH4OyXT_s=");
height:100%;
background-size:99%;
background-repeat:no-repeat; 
}
</style>
<style type="text/css">
div {
	position: absolute;
	top: 35%;
	right: 17%;
	left: 29%;
}
</style>
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
	
	<div align="center">
	<h3><a href="/viewstockmanager">BACK</a></h3>
	<h3><a href="/manager">HOME</a></h3>
	</div>
</body>
</html>