<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<style type="text/css">
body {
	background-image:
		url("https://media.istockphoto.com/photos/supermarket-aisle-with-empty-green-shopping-cart-picture-id817240836?k=6&m=817240836&s=612x612&w=0&h=I_77CJZV_tl3kdN-R1yav7jIa4lOs4JgqZZH4OyXT_s=");
	height: 100%;
	background-size: 99%;
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
</head>
<body>
	<h1 align="center">VIEW STOCK</h1>
	<div align="center">

		<form name="form1" action="/viewstockdetails">
			<br> Select Product : <select name="productId">
				
				<c:forEach items="${productlist}" var="product">
					<option value="${product.getId()}">${product.getName()}</option>
				</c:forEach>
			</select> <br> <br>&nbsp; &nbsp; &nbsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input type="submit"
				value="ViewStock" /> &emsp;&emsp;&emsp;
			<h3><a href="/admin">HOME</a></h3>
		</form>

	</div>
	<br />


</body>
</html>