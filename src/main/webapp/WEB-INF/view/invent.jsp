<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<link rel="icon" href="../image/ex1.png" />
<title>CRUD Application</title>

<style>
.inner {
	margin: 15px 0;
}
.cwidth{
	padding: 0 0 0 0;
}
</style>
</head>
<body>
	<div class="container-fluid cwidth" width="100%">
		<nav class="navbar navbar-dark" style="background-color:tomato">
			<a href="/" style="font-weight:bold;font-size:30px;" class="navbar-brand">main</a>
			<h4 class="navbar-brand" style="padding-right:60%;padding-bottom:0px;">Product view</h4>
			<form class="form-inline" action="invent.jsp">
				<a href="/AdminLogin" style="font-size:20px; padding-right:10px; color:#ffffff;">Admin Dashboard</a>
			</form>
		</nav>
	</div>
	<div class="container">
		<div class="inner">
			<div class="row">
				<div class="col-md-3">
					<h3>ADD PRODUCT </h3>
					<form action="inventory" method="post" enctype="multipart/form-data" >
						<div class="form-group">
							<label>Product Name</label> <input class="form-control"
								name="pname" place-holder="Product Name" required>
						</div>
						<div class="form-group">
							<label>Quantity</label> <input class="form-control"
								name="quantity" place-holder="Quantity " required>
						</div>
						<div class="form-group">
							<label>Price Per Hour</label> <input class="form-control"
								name="priceperhr" place-holder="Price per hr " required>
						</div>
						<div class="form-group">
							<label>Product Image</label> <input class="form-control" type="file"
								name="pimage" place-holder="Product Image" accept="image/jpeg,image/png">
						</div>
						
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
					</form>
				</div>
				<div class="col-md-9">
					<h3>Product Information From Database</h3>
					<table class="table">
						<thead class="bg-light">
							<tr>
								<th scope="col">Product Id</th>
								<th scope="col">Product Name</th>
								<th scope="col">Quantity</th>
								<th scope="col">Price Per Hour</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tempPro" items="${list}">
								<tr>
									<td>${tempPro.product_id }</td>
									<td>${tempPro.pname }</td>
									<td>${tempPro.quantity }</td>
									<td>${tempPro.priceperhr }</td>
									<td><a
					                     href="/editproduct?product_id=${tempPro.product_id }">Edit</a>
										<a href="/deleteproduct?product_id=${tempPro.product_id }">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

