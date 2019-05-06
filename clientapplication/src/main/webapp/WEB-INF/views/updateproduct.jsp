<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">


		<h3>Select Product</h3>
		<select id="product">
			<option value="0">--------Select Product-----</option>
			<c:forEach items="${productlist}" var="product">
				<option value="${product.getId()}">${product.getName()}</option>
			</c:forEach>
		</select> <br> <br> &emsp;&emsp;&emsp;&emsp;
		<button onclick="myFunction()">Update</button>
		&emsp;&emsp;&emsp;

		<!-- <h5 align="center">
				<a href="/manager">Home</a>
			</h5> -->

	</div>
	
	<div style="display: none" id="form">
		<form action="">
			id <input id="ID" type="text" disabled="disabled">
		</form>
	</div>
	
	<%-- <div class="modal fade" id="form" style="display: none;" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">UPDATE PRODUCT</h4>
				</div>
				<div class="modal-body">
					<form id="updateForm" onsubmit="updation(event)">
					
					</form>
				</div>
				<div class="modal-footer">
					
					<a type="button" class="btn btn-info" href="/manager">Home</a>
				</div>
			</div>

		</div>
	</div> --%>

	<script>
		function myFunction() {
			let id=document.querySelector("#product").value;
			$("#myModal").modal("show");
			let req = new XMLHttpRequest();
			req.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					product = JSON.parse(this.response);
					setProductForm(product);
				}
			};
			req.open("GET", "http://localhost:8072/api//product/" + id, true);
			req.send();
		}
		
		function setProductForm(product){
			/* let form=document.querySelector("#updateForm");
			form.innerHTML="<input type='textbox' name='name' value='"+product.name+"'/>"+
			               "<input type='textbox' name='description' value='"+product.description+"'/>"+
			               "<input type='submit' value='Update' class='btn btn-success'>" */
			               
			  var form =document.getElementById('form');
			  form.style.display = "block"
			 
		}
		
		function updation(event){
			event.preventDefault();
			let id=document.querySelector("#product").value;
			let inputs=document.getElementsByTagName("input");
			let data={};
			for(let i=0;i<inputs.length;i++){
				if(inputs[i].type!="submit")
				data[""+inputs[i].name+""]=inputs[i].value;
			}
			console.log(data);
			let req = new XMLHttpRequest();
			req.open("PUT", "http://localhost:8072/api/product/"+id, true);
			req.setRequestHeader("Content-type", "application/json");
			req.send(data);
		}
	</script>

</body>
</html>