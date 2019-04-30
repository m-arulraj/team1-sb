<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
		<button
			class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i> &nbsp;Menu
		</button>
		<span class="w3-bar-item w3-right">Welocome To Stock Book</span> <span
			class="w3-bar-item w3-center"> ADMIN</span>
	</div>

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-collapse w3-white w3-animate-zoom"
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		<div class="w3-container w3-row">
			<div class="w3-col s4"></div>
			<div class="w3-col s8 w3-bar">
				<span>WELCOME <strong>ADMINISTRATOR</strong></span><br>
			</div>
		</div>
		<hr>
		<div class="w3-container">
			<h5>DASHBOARD</h5>
		</div>
		<div class="w3-bar-block">
			<a href="/registermanager" class="w3-bar-item w3-button w3-padding "><i
				class="fa fa-user-plus fa-fw"></i>&nbsp; Add Manager</a>
				
				 <a href="/registerBiller" class="w3-bar-item w3-button w3-padding">
				 <i class="fa fa-user-plus fa-fw"></i>&nbsp; Add Biller </a>
				
				 <a href="/viewstock" class="w3-bar-item w3-button w3-padding">
				 <i class="fa fa-eye fa-fw"></i>&nbsp; View Stock</a>
				
				 <a href="/block"
				class="w3-bar-item w3-button w3-padding"><i
				class=" fa fa-ban fa-fw"></i>&nbsp; Block user </a> 
				
				 <a href="/"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-sign-out"></i>&nbsp; Logout</a> 
				
				
		</div>
	</nav>


	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">


		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px">
			<h5>
				<b><i class="fa fa-dashboard"></i> DASHBOARD</b>
			</h5>
		</header>

		<div class="w3-row-padding w3-margin-bottom">
			<div class="w3-quarter">
				<div class="w3-container w3-red w3-padding-16">
					<a href="/registermanager" class="w3-bar-item w3-button"><i
						class="fa fa-plus" style="font-size: 48px; color: black"></i></a>
					<!--  <div class="w3-right">
          <h3>52</h3>
        </div> -->
					<div class="w3-clear"></div>
					<h4>Add Manger</h4>
				</div>
			</div>
			<div class="w3-quarter">
				<div class="w3-container w3-blue w3-padding-16">
					<a href="/registerBiller" class="w3-bar-item w3-button"><i
						class="fa fa-plus" style="font-size: 48px; color: black"></i></a>
					<!-- <div class="w3-left">
						<h3>99</h3>
					</div> -->
					<div class="w3-clear"></div>
					<h4>Add Biller</h4>
				</div>
			</div>
			<div class="w3-quarter">
				<div class="w3-container w3-teal w3-padding-16">
					<div class="w3-left">
						<a href="/viewstock" class="w3-bar-item w3-button"><i
							class="fa fa-eye" style="font-size: 48px; color: black"></i></a>
					</div>
					<div class="w3-clear"></div>
					<h4>View Stock</h4>
				</div>
			</div>
			<div class="w3-quarter">
				<div class="w3-container w3-brown w3-text-white w3-padding-16">
					<div class="w3-left">
						<a href="/chartdata" class="w3-bar-item w3-button"> <i
							class="fa fa-bar-chart w3-xxxlarge"></i></a>
					</div>
					<div class="w3-right"></div>
					<div class="w3-clear"></div>
					<h4>View Profit</h4>
				</div>
			</div>
		</div>

		<div class="w3-panel">
			<div class="w3-row-padding" style="margin: 0 -16px"></div>
		</div>
		<hr>
		<div class="w3-container">
			<h5>Product Quantity Available</h5>
			<p>Fast Moving Item</p>
			<div class="w3-grey">

				<div class="w3-container w3-center w3-padding w3-red"
					style="width: 25%">20</div>
			</div>



			<p>Slow Moving Item</p>
			<div class="w3-grey">
				<div class="w3-container w3-center w3-padding w3-green"
					style="width: 75%">75</div>
			</div>
		</div>


		<!-- End page content -->
	</div>

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