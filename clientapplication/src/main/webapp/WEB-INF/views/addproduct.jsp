<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
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

	<div>
		<form:form name="form1" action="/add/product/table" method="post"
			modelAttribute="product">
			
				Product Name: <form:input type="text" path="name" />&emsp;&emsp;
				Description: <form:input type="text" path="description" />
			&emsp;&emsp;
			
			<br>
			<br>
			<br>
				Select category <form:select path="category.id">
				<form:option value="0">-----Select the Category-----</form:option>
				<c:forEach items="${categorylist}" var="category">
					<form:option value="${category.getId()}">${category.getName()}</form:option>
				</c:forEach>
			</form:select>
			<br>
			<br>
			<input type="submit" value="Add" />
			&emsp;&emsp;&emsp;

			<h5 align="center">
				<a href="/manager">Home</a>
			</h5>
		</form:form>
	</div>
	<br />



</body>
</html>