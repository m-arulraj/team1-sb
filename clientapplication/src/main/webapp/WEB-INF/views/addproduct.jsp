<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<div class="w3-container">
			<form:form name="form1" class="w3-card-4 w3-margin w3-padding w3-container" action="/add/product/table" method="post"
				modelAttribute="product">
					<h2 class="w3-center w3-green w3-border">ADD PRODUCT DETAILS</h2>
					<br>
					<label class="w3-text-large"><strong>Product Name</strong></label>
					<form:input type="text" class="w3-input w3-border" path="name" required="required" />
					<br>
					<label><strong>Description</strong></label> 
					<form:input type="text" class="w3-input w3-border" path="description" required="required"/>
					<br>	
					<label><strong>Select Category</strong></label>
					<form:select path="category.id" class="w3-input w3-border">
					<form:option value="0">-----Select the Category-----</form:option>
					<c:forEach items="${categorylist}" var="category">
						<form:option value="${category.getId()}">${category.getName()}</form:option>
					</c:forEach>
				</form:select>
				<br>
				<br>
				<center>
				<input type="submit" class="w3-button w3-green w3-center"
				style="width: 150px;" value="Add Product " />
				<br>	<br>	
				</center>
			</form:form>
			<br>	
		</div>
	
</div>
<%@include file="manager-fragments/footer.jsp"%>
</body>
</html>