<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>ADMINISTRATOR</title>
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
	<%@include file="admin-fragments/admin-nav.jsp"%>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-container w3-padding "
		style="margin-left: 300px; margin-top: 43px;">

		<form name="form1 " class="w3-form w3-container w3-border "
			action="/blockUser">
			<h3 class="w3-green w3-container w3-center">Block User</h3>
			<br>
			<label><b>Select User</b></label>
			<select name="userId" id="getName" class="w3-input w3-border" onchange="getRole(event)">
				<option>-----Select User-----</option>
				<c:forEach items="${usersList}" var="users">
					<option value="${users.getId()}" >${users.getName()}</option>
					
				</c:forEach>

			</select>
			<br>
		

			<center>
				<input type="submit"
					class="w3-button w3-margin w3-green w3-hover-red"
					style="width: 200px;" value="BLOCK" /> &emsp;&emsp;&emsp;
			</center>
			<br>
		</form>
	</div>
	<script type="text/javascript">
	
	function getRole(e)
	{
		console.log(document.getElementById('getName').innerText);
	}
	
	</script>
	
</body>
</html>

