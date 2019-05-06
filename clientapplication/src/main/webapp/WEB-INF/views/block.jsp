<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BLOCK USER</title>

<style type="text/css">
body{
background-image:
 url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-U04PwbidSQhh8IjNTydzvbd-rp9IcjqBhz_TT82roRkNqxqaQA");

height:100%;
background-size:46%;
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
</head>


<body>
<div align="center">
<form name="form1" action="/blockUser">
			<br> Select User : <select name="userId" >
				<option>-----Select User-----</option>
				<c:forEach items="${usersList}" var="users" >
					<option value="${users.getId()}">${users.getName()}</option>
				</c:forEach>
			</select> <br> <br>&nbsp; &nbsp; &nbsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input type="submit"
				value="BLOCK" /> &emsp;&emsp;&emsp;

                <h3><a href="/admin">BACK</a></h3>
		</form>
		</div>
</body>
</html>

