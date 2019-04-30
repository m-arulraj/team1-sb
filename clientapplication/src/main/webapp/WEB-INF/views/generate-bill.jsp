<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Generate Bill</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#myInput { #myInput { border-box:box-sizing;
	background-image: url('searchicon.png');
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
	border-bottom: 1px solid #ddd;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: show;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	border: 1px solid #ddd;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">
	<%@include file="biller-fragments/util.jsp"%>
	<%@include file="biller-fragments/biller-header.jsp"%>

	<%@include file="biller-fragments/biller-sidebar.jsp"%>



	<br>
	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<div class="w3-row-padding ">
			
			
			
			
			<form action="/biller/stockBill">
				<div class="w3-half">

					<input type="text" class="w3-input" name="productId"
						list="productName" id="myInput" placeholder="Enter Product Name"
						onkeyup="filterFunction()">
					<datalist id="productName">
						<c:forEach items="${products}" var="product">
							<option value="${product.getId()}" id="pId">${product.getName()}</option>
						</c:forEach>
					</datalist>
				</div>
				<div class="w3-half">
					<button class="w3-button w3-green" onclick="getStock()">GET
						PRODUCT</button>
				</div>
			</form>

		</div>
		

		<br>

		<div class="w3-container">
			<h5 class="w3-bar w3-pale-red w3-center ">Stock details</h5>
			<table class="w3-table-all">
				<tr class="w3-black">
					<th>ID</th>
					<th>MANUFACTURER</th>
					<th>QUANTITY</th>
					<th>SELLING PRICE</th>
					<th>DISCOUNT</th>
					<th>GST</th>
				</tr>
				<c:forEach items="${stockdetails}" var="stockdetails">
			<tr>
				<td><a href="/biller/getstock?stockId=${stockdetails.getId()}">${stockdetails.getId()}</a></td>
				<td>${stockdetails.getManufacturer()}</td>
				<td>${stockdetails.getQuantity()}</td>
				<td>${stockdetails.getSellingPrice()}</td>
				<td>${stockdetails.getDiscount()}</td>
				<td>${stockdetails.getGst()}</td>
			</tr>
		</c:forEach>
			</table>
		</div>
		
		<div>
		<h5 class="w3-bar w3-pale-red w3-center">Bill Details</h5>
		CUSTOMER NAME <input type="text"> &emsp;&emsp; 
		CONTACT NUMBER <input type="tel">
		</div>
		
		
		
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script>
		function filterFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementByTagName("a");

			for (i = 0; i < a.length; i++) {
				txtValue = a[i].textContent || a[i].innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					a[i].style.display = "";
				} else {
					a[i].style.display = "none";
				}
			}
		}
		function getStock() {
			var id=document.getElementById("myInput").value;
	/* 		window.location.assign("/biller/bill?productId="+id); */
		}

		
	</script>
</body>
</html>