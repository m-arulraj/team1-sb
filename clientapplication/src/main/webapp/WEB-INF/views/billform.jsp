<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BILL</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<style type="text/css">
body {
	background-image:
		url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpdXfxaqdRGG0NwHndf-T7GULaHxmo5oeMgY170e7O4ywpL6DG-Q");
	background-size: cover;
	background-repeat: no-repeat;
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
<style type="text/css">
div {
	position: absolute;
	top: 35%;
	right: 17%;
	left: 29%;
}
</style>

</head>
<h1 align="center">BILL FORM</h1>
<body >
<form:form name="form1" action="/biller/add/bill" method="post"
			modelAttribute="billdata" >
	<div>
        BILLER NAME: <form:input type="text" path="billerName"/>&emsp;&emsp;&emsp;&emsp;
		CUSTOMER NAME: <form:input type="text" path="name" />&emsp;&emsp; <br> <br> 
		 
		DATE:<form:input type="date" path="billDate"/> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		 
		CONTACT NUMBER:<form:input type="text" path="contact"/>&emsp;&emsp; <br> <br>


		
		
		 
		QUANTITY: <form:input type="number" path="quantity"/> &emsp;&emsp; &emsp;&emsp;&emsp;
		
		GST: <form:input type="text" path="gst" value="${stockdata.getGst()}"/> &emsp;&emsp; <br> <br> <br> 
		
		DISCOUNT: <form:input type="text" path="discount" value="${stockdata.getDiscount()}"/>&emsp;&emsp;&emsp;&emsp;
		
		
		SELLINGPRICE: <form:input type="text" path="sellingprice" value="${stockdata.getSellingPrice()}"/> &emsp;&emsp; <br> <br> 
		
	   
		
		
		<br> <input type="submit" value="Add" />
	</div>
	</form:form>
	
	



</body>
</html>