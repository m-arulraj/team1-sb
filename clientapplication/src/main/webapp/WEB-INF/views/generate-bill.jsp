<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Generate Bill</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#myInput { #myInput { border-box:box-sizing;
	background-image: url('searchicon.png');
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
	border-bottom: 1px solid #ddd;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: show;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	border: 1px solid #ddd;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">
	<%@include file="biller-fragments/util.jsp"%>
	<%@include file="biller-fragments/biller-header.jsp"%>
	<%@include file="biller-fragments/biller-sidebar.jsp"%>

	<br>
	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<div class="w3-row-padding ">
			<div class="w3-half w3-padding">
				<input type="text" class="w3-input w3-border" name="productName"
					list="productName" id="productId"
					placeholder="Enter Product Name/code">
				<datalist id="productName">
					<c:forEach items="${products}" var="product">
						<option value="${product.getId()}" id="pId">${product.getName()}</option>
					</c:forEach>
				</datalist>
			</div>
			<div class="w3-half w3-padding">
				<button class="w3-button w3-green" onclick="getProduct(event);">GET
					PRODUCT</button>
			</div>

		</div>
		<br>



		<div class="w3-container" style="display: none;" id="stockDetails">
			<h5 class="w3-bar w3-pale-red w3-center ">Stock details</h5>
			<table class="w3-table-all" id="stockTable">
			</table>
		</div>
		<br>
		<hr class="w3-border">
		<div class="w3-container w3-border">
			<form action="/biller/add/bill" method="post">
			<div >

				<h5 class="w3-bar w3-pale-yellow w3-center">Bill Details</h5>
				CUSTOMER NAME <input type="text" required name="cName"> &emsp;&emsp; CONTACT
				NUMBER <input type="tel" required name="cContact">
			</div>

			<br>

			<div>
				<table class="w3-table-all" id="billTable">
					<tr class="w3-black">
						<th>&nbsp;</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Discount</th>
						<th>Gst</th>
						<th>Total</th>
					</tr>

				</table>
			</div>
			<br><br>
			<div class="w3-container w3-right w3-navbar">
				<label class=" w3-row"><b>Grand Total :</b></label>
				<input id="grandTotal" class="w3-row w3-margin w3-border" value="0" type="text" name="grandTotal">
			<input type="submit" class="w3-button w3-blue 	" value="Generate Bill">
			</div>
			<br>
			</form>
		</div>
		<br>
		<br>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script>
		function filterFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementByTagName("a");

			for (i = 0; i < a.length; i++) {
				txtValue = a[i].textContent || a[i].innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					a[i].style.display = "";
				} else {
					a[i].style.display = "none";
				}
			}
		}
			
		
		
		
		var stock;
		var product;
		function getProduct(e) {
			var productId = document.getElementById("productId").value;
			document.getElementById("stockDetails").style.display = "block";

			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					 product = JSON.parse(this.response);
					
					setStock(product.stockList);
				}
			};
			xhttp.open("GET", "/product?productId=" + productId, true);
			xhttp.send();
		}
		
		function setStock(stock) {
			var stockDetails = document.getElementById("stockTable");
			stockDetails.innerHTML = "";
			stockDetails.innerHTML = "<table class='w3-table-all'  >"
					+ "<tr class='w3-black'>" + "<th>ID</th>"
					+ "<th>MANUFACTURER</th>" + "<th>QUANTITY</th>"
					+ "<th>SELLING PRICE</th>" + "<th>DISCOUNT</th>"
					+ "<th>GST</th>" + "<th>Action</th>" + "</tr>";

			console.log(stock.length)
			stock.forEach(function(s) {
				stockDetails.innerHTML += "<tr>" +
				"<td>" + s.id +
				"<td>" + s.manufacturer + "</td>" + "<td>" + s.quantity
						+ "</td>" + "<td>" + s.sellingPrice + "</td>" + "<td>"
						+ s.discount + "</td>" + "<td>" + s.gst + "</td>"
						+"<td><input type='button' value='Add' class='w3-button w3-green'"+
						
						"onclick='addToBill("+JSON.stringify(s)+")'></td>"+ 
						"</tr>"
			})
			
		}

		var cell6;
		//need to work
		function addToBill(s) {
			var table = document.getElementById("billTable");
			var row = table.insertRow();
			var cell0 = row.insertCell();
			var cell1 = row.insertCell();
			var cell2 = row.insertCell();
			var cell3 = row.insertCell();
			var cell4 = row.insertCell();
			var cell5 = row.insertCell();
			cell6 = row.insertCell();
			cell0.innerHTML = "<input type='button' class='w3-button ' value='&#10060;'onclick='remove(this)'>";
			cell1.innerHTML = "<td>"+product.name+"</td>";
			cell2.innerHTML = "<input type='number' value='1' style='width:60;' min='1' onchange='amount(event,this,"+JSON.stringify(s)+")'>";
			
			cell3.innerHTML = "<td>"+s.sellingPrice+"</td>";
			cell4.innerHTML =  "<td>"+s.discount+"</td>";
			cell5.innerHTML =  "<td>"+s.gst+"</td>";
			cell6.innerHTML =  "<td>"+(s.sellingPrice + s.gst -s.discount)+"</td>";
			cell6.classList.add("count");
			gt = s.sellingPrice + s.gst -s.discount;
			document.getElementById("grandTotal").value = gt ;
			grandTotal();
		}
		 var gt;
		 var previousQty=1;
		
		 function amount(e,r,s)
		{
		 	var qty = e.target.value;
					console.log(e);
			var total = qty * (s.sellingPrice + s.gst -s.discount);
			/* cell6.innerHTML = total; */
			
			 e.path[2].cells[6].innerHTML = total;
		
			
			grandTotal()
			 
		}
		
		 function grandTotal()
		 {
			 var table = document.getElementById("billTable");
				
				var ths = table.getElementsByTagName('th');
				var tds = table.getElementsByClassName('count');
				console.log(tds.length);
			 var sum = 0;
				for(var i=0;i<tds.length;i++){
				   sum += Number(tds[i].innerText) ;
				}
			
				document.getElementById("grandTotal").value = sum;
				
		 }
		 
		 
		 
		 function remove(r)
		 {
			  var i = r.parentNode.parentNode.rowIndex;
			  document.getElementById('billTable').deleteRow(i);
			  grandTotal();
			  
		 }
	</script>
</body>
</html>