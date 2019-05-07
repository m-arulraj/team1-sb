<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>The Stock Book Registration Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	
	font-family: 'Roboto', sans-serif;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	margin: 0 auto;
	padding: 30px 0;
}
.modal-body,.modal-header{
color:black;
}
.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}

.signup-form h2:before {
	left: 0;
}

.signup-form h2:after {
	right: 0;
}

.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	min-width: 140px;
	outline: none !important;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%@include file="admin-fragments/admin-nav.jsp"%>

	<div class="w3-main w3-container w3-padding w3-card" style="margin-left: 300px; margin-top: 43px;">
		<div class="signup-form">
			<form:form action="/user" method="post" modelAttribute="user">
				<h2>Register</h2>
				<p class="hint-text">Create account</p>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<form:input type="text" class="form-control" path="name"
								placeholder="Name" required="required" />
						</div>
						<div class="col-xs-6">
							<form:input type="text" class="form-control" path="username"
								placeholder="User Name" required="required" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<form:input type="email" class="form-control" path="email"
						placeholder="Email" required="required" />
				</div>
				<div class="form-group">
					<form:input type="password" class="form-control" path="password"
						placeholder="Password" required="required" />
				</div>
				<div class="form-group">
					<form:input type="tel" class="form-control" path="contact"
						placeholder="Phone Number" required="required" />
				</div>

				<div class="form-group">
					<h5>Select Role</h5>
					<form:select name="cars" class="form-control" required="required"
						path="authorities.role">
						<form:option value="MANAGER">MANAGER</form:option>
					</form:select>
					<br> <br>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-success btn-lg btn-block">Register
						Now</button>
				</div>
				<div align="center">
					<a href="/admin"> HOME</a>
				</div>


			</form:form>
		</div>
		<c:if test="${generated}">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">REGISTERED Status</h4>
						</div>
						<div class="modal-body">
							<p>USER ADDED SUCCESSFULLY</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
								data-dismiss="modal">OK</button>
						</div>
					</div>

				</div>
			</div>

		</c:if>

		<script>
			$(document).ready(function() {
				// Show the Modal on load
				$("#myModal").modal("show");
			});
		</script>

	</div>
	<%@include file="admin-fragments/footer.jsp"%>
</body>
</html>
