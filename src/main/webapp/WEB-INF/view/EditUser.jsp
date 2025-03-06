<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<a href="index.jsp" style="font-weight:bold;font-size:30px;" class="navbar-brand">main</a>
			<form class="form-inline" action="invent.jsp">
				<a href="UserManage.jsp" style="font-size:20px; padding-right:10px;">User List </a>
			</form>
		</nav>
	</div>
<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3>
Edit User Details</h3>
<form:form action="save" method="post" modelAttribute="user" >
                            <div class="form-group">
                                
                                <form:input class="form-control" path="u_id" type="hidden"  />
                            </div>
<div class="form-group">
                                <label>First Name</label>
                                <form:input class="form-control" path="fname" />
                            </div>
<div class="form-group">
                                <label>Last Name</label>
                                <form:input class="form-control" path="lname"/>
                            </div>
                           
<div class="form-group">
                                <label>Date Of Birth</label>
                                <form:input class="form-control" path="dob" type="date"  />
                             </div>                 
<div class="form-group">
                                <label>Gender</label>
                                <form:input class="form-control" path="gender"  />
                            </div>
<div class="form-group">
                                <label>Phone Number </label>
                                <form:input class="form-control" path="phoneno" />
                            </div>
<div class="form-group">
                                <label>Email</label>
                                <form:input class="form-control" path="email" type="email"  />
                             </div>                                                     
                          <div style="color: #FF0000;">${errorMessage}</div><br>
<button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="UserManage.jsp">Cancel</a></button>
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