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
			<br> Select Product : <select name="productId" >
				<option>-----Select Product-----</option>
				<c:forEach items="${productlist}" var="product" >
					<option value="${product.getId()}">${product.getName()}</option>
				</c:forEach>
			</select> <br> <br>&nbsp; &nbsp; &nbsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input type="submit"
				value="ViewStock" /> &emsp;&emsp;&emsp;


		</form>
	</div>
	<br />


</body>
</html>