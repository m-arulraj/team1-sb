<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<!-- Top container -->
	<div class="w3-bar w3-top w3-blue w3-large " style="z-index: 4">
		
		<span class="w3-bar-item w3-right">Welocome To Stock Book</span>
		<span class="w3-bar-item w3-center"> MANAGER LOGIN</span>
	</div>
	<br>
	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-collapse w3-white w3-xlarge  w3-border"
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		
		
		<div class="w3-bar-block ">
			<a href="#"
				class="w3-bar-item w3-button w3-padding-16 w3-hide-large  w3-hover-pale-red"
				onclick="w3_close()" title="close menu"><i
				class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
				 <a href="/manager"
				class="w3-bar-item w3-button w3-padding w3-hover-pale-red "><i
				class="fa fa-home fa-fw"></i>&nbsp; Home</a>
				 <a href="/addproduct"
				class="w3-bar-item w3-button w3-padding w3-hover-pale-red "><i
				class="fa fa-user-plus fa-fw"></i>&nbsp; Add Product</a>
				 <a href="/manager/category"
				class="w3-bar-item w3-button w3-padding w3-hover-pale-red"><i
				class="fa fa-user-plus fa-fw"></i>&nbsp; Manage Category</a> 
				<a href="viewstockmanager"
				class="w3-bar-item w3-button w3-padding w3-hover-pale-red"><i
				class="fa fa-eye fa-fw"></i>&nbsp; View Stock</a> 
				<a
				href="/" class="w3-bar-item w3-button w3-padding w3-hover-pale-red"><i
				class="fa fa-sign-out"></i>&nbsp; Logout</a>
			
		</div>
	</nav>


	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

</body>
</html>