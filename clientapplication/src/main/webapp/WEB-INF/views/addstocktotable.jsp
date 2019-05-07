<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 20%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=number], select, textarea {
	width: 12%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=date], select, textarea {
	width: 16%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>

	<h1 align="center">ADD STOCK</h1>

	<div class="container">
		<form:form action="/addstocktotable" align="center" modelAttribute="stockdetails" >
			<label for="fname">Product Name</label> <input type="text" id="fname"
				name="firstname" value="${saved}"><br> <label for="lname"> Date</label>
			<input type="date" name="date"><br>

			
			<label for="quantity">Quantity</label> <input type="number"
				name="quantity" min="1" max="1000"><br> 
				
				<label for="subject">Manufacturer</label> <input type="text" 
				name="manufacturer" ><br>
				
				
				<label for="quantity">CostPrice/product</label> <input type="number"
				name="costPrice" value="0"> &emsp;&emsp;
				<label for="quantity">SellingPrice</label> <input type="number"
				name="sellingPrice" value="0"><br>  
				
				<label for="quantity">Discount</label> <input type="number"
				name="discount" value="0"> &emsp;&emsp;
				<label for="quantity">GST</label> <input type="number"
				name="gst" value="0"><br> 
				
				<label for="quantity">TotalCostPrice</label> <input type="number"
				name="totalCp" value="0"> &emsp;&emsp;
				<label for="quantity">Threshold</label> <input type="number"
				name="threshold" value="0"><br> 
				
				
				 <input type="submit" value="ADD">
				 <a href="/manager"  type="Button" class="w3-button w3-green w3-center"
					style="width: 150px;" >HOME</a> <br> <br>
				 
		</form:form>
	</div>

</body>
</html>
