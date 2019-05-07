	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
		<button
			class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i> &nbsp;Menu
		</button>
		<span class="w3-bar-item w3-right">Welocome To Stock Book</span>
		<span class="w3-bar-item w3-center"> MANAGER PAGE</span>
	</div>

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-collapse w3-white "
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		<div class="w3-container w3-row">
			<br>	<br>
			<div class="w3-col s8 w3-bar">
				<span>WELCOME <strong>MANAGER</strong></span><br>
			</div>
		</div>
		<hr>
		
		<div class="w3-bar-block ">
			<!-- <a href="#"
				class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
				onclick="w3_close()" title="close menu"><i
				class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a> --> <a href="/addproduct"
				class="w3-bar-item w3-button w3-padding "><i
				class="fa fa-user-plus fa-fw"></i>&nbsp; Add Product</a>
				 <a href="/manager/category"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-user-plus fa-fw"></i>&nbsp; Manage Category</a> <a href="viewstockmanager"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-eye fa-fw"></i>&nbsp; View Stock</a><!--  <a href="#"
				class="w3-bar-item w3-button w3-padding"><i

				class=" fa fa-ban fa-fw"></i>&nbsp; Block user </a> --> <a
				href="/" class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-sign-out"></i>&nbsp; Logout</a>
			
		</div>
	</nav>


	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

