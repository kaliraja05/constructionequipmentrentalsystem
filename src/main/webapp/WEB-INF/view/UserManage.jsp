<%@page import="java.util.List"%>
<%@ page import="com.construction.dao.UserDao" %>
<%@ page import="com.construction.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%-- <%
 /* UserDao userdao = new UserDao();
List<User> user = userdao.getUser(); */
request.setAttribute("USERS_LIST", user);
%> --%>
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
			<a href="index.jsp" style="font-weight:bold;font-size:30px;" class="navbar-brand">main</a>
			<h4 class="navbar-brand" style="padding-right:60%;padding-bottom:0px;">USER VIEW</h4>
			<form class="form-inline" action="invent.jsp">
				<a href="/AdminLogin" style="font-size:20px; paddinf-right:10px; color:#ffffff">Admin Dashboard</a>
			</form>
		</nav>
	</div>
		
		<div class="col-md-12">
					<h3>User Information From Database</h3>
					<table class="table table-bordered" style="margin-left:auto;margin-right:auto;">
						<thead class="bg-light">
							<tr>
								<th scope="col">USER ID</th>
								<th scope="col">FIRST NAME</th>
								<th scope="col">LAST NAME</th>
								<th scope="col">USER NAME</th>
								<th scope="col">DOB</th>
								<th scope="col">GENDER</th>
								<th scope="col">PHONE NUMBER</th>
								<th scope="col">EMAIL </th>
								<th scope="col">ACTION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tempuser" items="${list}">
								<tr>
									<td>${tempuser.u_id }</td>
									<td>${tempuser.fname }</td>
									<td>${tempuser.lname }</td>
									<td>${tempuser.uname }</td>
									<td>${tempuser.dob }</td>
									<td>${tempuser.gender }</td>
									<td>${tempuser.phoneno }</td>
									<td>${tempuser.email }</td>
									<td><a
					                     href="/edituser?u_id=${tempuser.u_id }">Edit</a>
										<a href="/deleteuser?u_id=${tempuser.u_id }">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
</body>
</html>