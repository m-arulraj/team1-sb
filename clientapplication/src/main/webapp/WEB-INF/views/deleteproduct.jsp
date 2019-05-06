<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>DELETE PRODUCT</title>
</head>
<body>
	<div align="center">
		<form name="form1" action="/delete">


			<h3>Select Product</h3>
			<select name="productId">
				<option value="0">--------Select Product-----</option>
				<c:forEach items="${productlist}" var="product">
					<option value="${product.getId()}">${product.getName()}</option>
				</c:forEach>
			</select> <br> <br> &emsp;&emsp;&emsp;&emsp;
			<input type="submit"  value="delete" >
			&emsp;&emsp;&emsp;

			<!-- <h5 align="center">
				<a href="/manager">Home</a>
			</h5> -->
		</form>
	</div>

<c:if test="${generated}">
	  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">DELETE Status</h4>
        </div>
        <div class="modal-body">
          <p>SELECTED ITEM DELETED</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
          <a type="button" class="btn btn-info" href="/manager" >Home</a>
        </div>
      </div>
      
    </div>
  </div>
  
	</c:if>

<script>$(document).ready(function(){
	  // Show the Modal on load
	  $("#myModal").modal("show");
});</script>
</body>

</html>