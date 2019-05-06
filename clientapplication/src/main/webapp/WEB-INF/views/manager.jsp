<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px">
			<h5>
				<b><i class="fa fa-dashboard">  </i>  DASHBOARD</b>
			</h5>
		</header>

		<div class="w3-row-padding w3-margin-bottom">
			<div class="w3-quarter">
				<div class="w3-container w3-red w3-padding-16">
					<a href="/addproduct"
					class="w3-bar-item w3-button">
					<i class="fa fa-plus" style="font-size: 48px; color: black"></i>
					</a>
					<h4>Add Product</h4>
				</div>
			</div>
			<div class="w3-quarter">
				<div class="w3-container w3-brown w3-padding-16">
					<a href="/addstockforexistingproduct"
					class="w3-bar-item w3-button"><i class="fa fa-plus" style="font-size: 48px; color: black"></i></a>
					<div class="w3-clear"></div>
					<h4>Add Stock</h4>
				</div>
			</div>
			
			<div class="w3-quarter">
				<div class="w3-container w3-teal w3-padding-16">
					<div class="w3-left">
						<a href="viewstockmanager"
					class="w3-bar-item w3-button"><i class="fa fa-eye" style="font-size: 48px; color: black"></i></a>
					</div>
				
					<div class="w3-clear"></div>
					<h4>View Stock</h4>
				</div>
			</div>
			

		<div class="w3-panel">
			<div class="w3-row-padding" style="margin: 0 -16px">
				
				</div>
			</div>
		</div> 
		<hr>
		<!-- <div class="w3-container">
			<h5>Product Quantity Available</h5>
			<h3><a href="/fastmoving">Fast Moving Item</a></h3>
			
			
			<div class="w3-grey">
			
				<div class="w3-container w3-center w3-padding w3-red"
					style="width: 25%"> 20</div>
			</div>

			

			<h3><a href="/">Slow Moving  Item</a></h3>
			<div class="w3-grey">
				<div class="w3-container w3-center w3-padding w3-green"
					style="width: 75%">75</div>
			</div>
		</div> -->
		
		
		
		<!-- End page content -->
	</div>
<%@include file="manager-fragments/footer.jsp"%>
	<script>
		// Get the Sidebar
		var mySidebar = document.getElementById("mySidebar");

		// Get the DIV with overlay effect
		var overlayBg = document.getElementById("myOverlay");

		// Toggle between showing and hiding the sidebar, and add overlay effect
		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
				overlayBg.style.display = "none";
			} else {
				mySidebar.style.display = 'block';
				overlayBg.style.display = "block";
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
			overlayBg.style.display = "none";
		}
	</script>

</body>
</html>