<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				Select category <form:select path="category">
				<option>-----Select the Category-----</option>
				<c:forEach items="${categorylist}" var="category">
					<form:option value="${category.getId()}">${category.getName() }</form:option>
				</c:forEach>
			</form:select>
			<br>
			<br>
			<input type="submit" value="Add" />
			&emsp;&emsp;&emsp;


		</form:form>
	</div>
	<br />


</body>
</html>