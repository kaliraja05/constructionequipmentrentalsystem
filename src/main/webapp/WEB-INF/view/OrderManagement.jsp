<%@page import="com.construction.model.Order"%>
<%@page import= "org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/order.css" type="text/css" />
<script src="https://kit.fontawesome.com/c6361b72de.js"
	crossorigin="anonymous"></script>
	<link rel="icon" href="../image/ex1.png" />
<title>Order Table</title>
</head>
<body>
	<nav>
		<div class="logo">
			<p>ConsEquip</p>

		</div>

		<ul>
			<!--  <li><a href="index.jsp">HOME</a></li>
                    <li><a href="login.jsp">Log In</a></li> -->
			<li><a href="AdminLogin">Admin Dashboard</a></li>


		</ul>
	</nav>

	<div class="col-md-12">
		<table class="table table-bordered"
			style="margin-left: auto; margin-right: auto;">
			<thead class="bg-light">
				<tr>
					<th scope="col">ORDER ID</th>
					<th scope="col">ORDER DATE</th>
					<th scope="col">USER ID</th>
					<th scope="col">PRODUCT NAME</th>
					<th scope="col">QUANTITY</th>
					<th scope="col">TOTAL PRICE</th>
					<th scope="col">TIME</th>
					<th scope="col">DELIVERY</th>
					<th scope="col">STATUS</th>
					<th scope="col">CURRENT STATUS</th>
					<th scope="col">ACTION</th>
				</tr>
			</thead>
			<c:forEach var="temporder" items="${listorder}">
			<form action="updateorder" method="post" >
				<tbody>
						<tr>
							<td><input name="order_id" type="hidden" value="${temporder.order_id }">${temporder.order_id}</td>
							<td>${temporder.orderdate }</td>
							<td>${temporder.u_id }</td>
							<td>${temporder.pro_name }</td>
							<td>${temporder.quant }</td>
							<td>${temporder.totalprice }</td>
							<td>${temporder.time }</td>
							<td><input name="delivery" type="date" value="${temporder.delivery }" ></td>
							<td><select name="status" type="text">
									<option>Pending</option>
									<option>Approved</option>
									<option>Rejected</option>
									<option>Delivered</option>
									<option>Recieved</option>
									<option>Defective</option>
									<option>Completed</option>
							</select></td>
							<td>${temporder.status }</td>
							<td><button type="submit"  class="btn btn-primary">Update</button></td>
							
						</tr>
				</tbody>
			</form>
			</c:forEach>
		</table>
	</div>
</body>
</html>