<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
    position:absolute;
    top:35%;
    right:17%;
    left:29%;
}
</style>
</head>
<body>

<div>
		<form name="form1" action="addprodcuts" method="post" >
			
				Product Name: <input type="text" name="pname">&emsp;&emsp;
				Select category <select name="institute">
					<option>-----Select the Category-----</option>
					<c:forEach items="${categorylist}" var="category">
						<option value="${category.getId()}">${category.getName()}</option>
					</c:forEach>
				</select><br> <br> <input type="submit" value="Add" "/>&emsp;

			
		</form></div>
		<br />
	

</body>
</html>