<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Biller Home</title>
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

	<%@include file="biller-fragments/util.jsp"%>
	<%@include file="biller-fragments/biller-header.jsp"%>

	<%@include file="biller-fragments/biller-sidebar.jsp"%>





	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">


		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px">
			<h5>
				<b><i class="fa fa-dashboard"></i> MY DASHBOARD</b>
			</h5>
		</header>

		<div class="w3-row-padding w3-margin-bottom">
			<div class="w3-third">
				<div class="w3-container w3-red w3-padding-16">
					<a href="/biller/bill" class="w3-bar-item w3-button"><i
						class="fa fa-file-text-o" style="font-size: 48px; color: black"></i></a>

					<div class="w3-clear"></div>
					<h4>Generate Bill</h4>
				</div>
			</div>
			<div class="w3-third">
				<div class="w3-container w3-blue w3-padding-16">
					<a href="/biller/updateform" class="w3-bar-item w3-button"><i
						class="fa fa-user-plus" style="font-size: 48px; color: black"></i></a>
					<div class="w3-clear"></div>
					<h4>Update Profile</h4>
				</div>
			</div>
			<div class="w3-third">
				<div class="w3-container w3-teal w3-padding-16">
					<div class="w3-left">
						<a href="/" class="w3-bar-item w3-button"><i
							class="fa fa-sign-out" style="font-size: 48px; color: black"></i></a>
					</div>
					<div class="w3-clear"></div>
					<h4>Logout</h4>
				</div>
			</div>
		</div>

		<div class="w3-panel">
			<div class="w3-row-padding" style="margin: 0 -16px"></div>
		</div>
		<hr>
	</div>


</body>
</html>