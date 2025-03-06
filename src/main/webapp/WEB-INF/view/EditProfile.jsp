<%@page import="com.construction.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="icon" href="../image/ex1.png" />
        <title>Edit User Data</title>
        <style>
            .inner{
                position: relative;
                margin: 0 auto;
                width: 650px;
                display: block;
                padding: 50px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
            .cwidth{
                padding: 0 0 0 0;
            }
        </style>
    </head>
    <body>
      <div class="container-fluid cwidth" width="100%">
		<nav class="navbar navbar-dark" style="background-color:tomato">
			<a href="welcome.jsp" style="font-weight:bold;font-size:30px;" class="navbar-brand">main</a>
			<form class="form-inline" action="invent.jsp">
				<a href="welcome.jsp" style="font-size:20px; padding-right:10px;">Home Page </a>
			</form>
		</nav>
	</div>
<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3>Edit Details</h3><br>
<%-- <div class="message" style="color: #FF0000;text-align:center;">${Message}</div><br> --%>

<form:form action="EditDetails" method="post" modelAttribute="user">
                            <div class="form-group">
                                <form:input class="form-control" type="hidden" name="u_id" path="u_id"  />
                            </div>
<div class="form-group">
                                <label>First Name</label>
                                <form:input class="form-control" name="fname" path="fname" />
                            </div>
<div class="form-group">
                                <label>Last Name</label>
                                <form:input class="form-control" name="lname" path="lname" />
                            </div>
<div class="form-group">
                                <label>Phone Number </label>
                                <form:input class="form-control" name="phoneno" path="phoneno" />
                            </div>
<div class="form-group">
                                <label>Email</label>
                                <form:input class="form-control" name="email" type="email" path="email" />
                             </div>                                                     
                          
						<button type="submit" class="btn btn-primary" >Submit</button>
                            <button  class="btn btn-primary"><a href="welcome.jsp">Cancel</a></button>
                        </form:form>
</div>
</div>
</div>
</div>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    </body>
</html>