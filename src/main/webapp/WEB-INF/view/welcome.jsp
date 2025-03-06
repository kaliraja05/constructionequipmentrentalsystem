<%@page import="com.construction.model.User"%>
<%@page import="com.construction.model.Product"%>
<%@page import="java.util.List"%>
<%@ page import="com.construction.dao.UserDaoImpl" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../image/ex1.png" />
    <title>User Home</title>

   <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
    integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous">
  </script>
  <script src="https://kit.fontawesome.com/c6361b72de.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
   <!-- CSS FILE -->
   <link rel="stylesheet" href="css/welcome.css" type="text/css"/>

</head>
<%
	User user = (User)session.getAttribute("user");
%>
<body>


    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#"><%= user.getFname()%> <%= user.getLname()%></a>
        <a href="/EditProfile?u_id=<%= user.getU_id()%>">Edit Profile</a>
        <a href="#">Help</a>
        <a href="userlogout">Logout</a>
               
       	<div id="divId" class="message" style="color: pink;text-align:center;font-weight:bold;text-decoration:underline;">${Message}</div><br>
    </div>

    <nav id="main">
        <div class="logo" style="width: 100%; margin-left:auto; margin-right: auto;">
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; main</span>
            <span style="padding-left:45%"></span> 
            <span><a style="color: white;" href="" onclick="check()"  data-bs-target="#OrderPopup"  data-bs-toggle="modal" >My Orders</a></span>
            <span><a style="color: white;padding-left:2%" href="" οnclick="Value('${cart_list}')"data-bs-toggle="modal" data-bs-target="#OrderModal"><i  class="fab fa-opencart fa-2x"></a></i></span>
            
        	<span><a  style="color: #fff;padding-left:2%" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal"> Change Password</a></span>
            <span style="color:#fff; padding-left:2%;">Hello, <%= user.getFname()%> <%= user.getLname()%></span>
        </div>
    </nav>

    <section class="Colured-section" id="testimonials">
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active container-fluid">
          <h2 class="Testimonial-text">Team work divides the Task and multiplies the Success</h2>
          <image class="testimonial-image" src="image/carousel1.jfif" alt="profile">
         

        </div>
        <div class="carousel-item container-fluid">
          <h2 class="Testimonial-text">If we shape our Buildings;Thereafter they shape us</h2>
          <a href="#"><image class="testimonial-image" src="image/carousel2.jfif" alt="profile"></a>
        

        </div>
        <div class="carousel-item container-fluid">
          <h2 class="Testimonial-text">Construction is a matter of optimism; It's a matter of facing the future with confidence.</h2>
          <image class="testimonial-image" src="image/carousel3.jfif" alt="profile">
        </div>
      </div>
      <button class="carousel-control-prev previousButton" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next nextButton" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    </section>
    
    
    <div class="gallery">
 <%
        /*  UserDaoImpl userdaoimpl = new UserDaoImpl();
       /*  int u_id = ((int)session.getAttribute("u_id")); */
       /*  User nuser = userdaoimpl.getUserById(u_id); */  
      
       List<Product> productlist = (List<Product>)session.getAttribute("productlist");
    for(Product pr: productlist)
	{
	%>
      <div class="content">
		<image src="GetImage?product_id=<%=pr.getProduct_id() %>" height=100 width=150>
        <font size="5"><%= pr.getPname() %></font><br>
        <font size="3">In Stock :<%=pr.getQuantity() %></font><br>
        <font size="3">Rs.<%=pr.getPriceperhr() %> per hour</font>
        
         <button class="buy-2">
        <a href="/addtocart?product_id=<%=pr.getProduct_id()%>&u_id=${u_id}"  style="color: #ffffff;">RENT ME</a></button>
      </div>
      <% 
		}
	  %>

<!-- change password modal -->
  


  
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header header">
          <h5 class="modal-title" id="exampleModalLabel">CHANGE PASSWORD</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="modal-body">
            <!-- formstarting -->
            <form action="ChangePassword" method="post"> 
              <input type="hidden" name="action" value="changePassword">

              <div class="form">
                <div class="form-group ">
                  <label for="inputPassword4">User Name</label>
                  <input type="text" value="<%=user.getUname()%>" class="form-control" id="inputPassword4" name="uname" readonly >
                </div><br>
               <!--  <div class="form-group ">
                  <label for="inputPassword4">Current Password</label>
                  <input type="password" class="form-control" id="inputPassword4" name="currentpassword"  >
                </div><br> -->
                <div class="form-group">
                  <label for="inputPassword4">New Password</label>
                  <input type="password" class="form-control" id="pass" name="newpassword" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$" title="Must Contain a Uppercase,Lowercase,Number and 8 Charater and a special character" required>
                </div>

              </div>

              <div class="modal-footer">

                <input type="submit" value="submit" class="btn btn-primary">
              </div>
            </form>
          </div>
        </div>

      </div>
    </div>
  </div>
<!-- End of Change Password popup -->

<!-- myCart popup -->

  <div class="modal fade tabsize" id="OrderModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content" style="width: 800px;">
        <div class="modal-header header" >
          <h5 class="modal-title" id="exampleModalLabel"> Cart</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="modal-body">
           
            <div class="modal-body">
            
              <table class="table tb-warning table-striped ">
            <thead>  
          <tr>
          	
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Time</th>
            <th>Price</th>
            <th>Option</th>
          </tr>
          </thead>
        <tbody>
		
         <c:forEach var="tempuser" items="${cartlist}">         
          <tr>
            <td>${tempuser.pro_id }</td>
            <td>${tempuser.p_name }</td>
            <td>${tempuser.quantity }</td>
            <td>${tempuser.time } hrs</td>
            <td>${tempuser.price }</td>
            <td><a href="deletecart?cart_id=${tempuser.cart_id }">Delete</a></td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
      </div>
          </div>
        </div>
		<div class="modal-footer ">
           <a href="cartorder?u_id=${u_id }" type="submit" class="btn-dark">RENT NOW</a>
                
        </div>
      </div>
    </div>
    
  </div>
  
  <!--Cart popup end -->

<!-- myOrder popup -->
  

  <div class="modal fade tabsize element" id="OrderPopup" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="marign-left: auto; marign-right: auto;">
    <div class="modal-dialog" style="margin-left: 170px;">
      <div class="modal-content" style="width: 1000px; align: center; margin-left: auto; margin-right: auto;">
        <div class="modal-header header" >
          <h5 class="modal-title" id="exampleModalLabel"> Order</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="modal-body">
           
            <div class="modal-body">
            
              <table  class="table tb-warning table-striped ">
            <thead>  
          <tr>
          	<th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Time</th>
            <th>Price</th>
            <th>Order Date</th>
            <th>Delivery</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
          </thead>
        
        <tbody>
        <c:forEach var="temporder" items="${orderlist }">
          <tr>
          <td>${temporder.p_id }</td>
            <td>${temporder.pro_name }</td>
            <td>${temporder.quant }</td>
            <td>${temporder.time }</td>
            <td>${temporder.totalprice }</td>
            <td>${temporder.orderdate }</td>
            <td>${temporder.delivery }</td>
            <td>${temporder.status }</td>
            <td><a  href="deleteorder?order_id=${temporder.order_id }">Cancel Order</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

        </div>
      </div>
                
          </div>
        </div>
		
      </div>
    </div>
    
  </div>
  
  <!--Order popup end -->

    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("main").style.marginLeft = "0";
        }

    </script>
<script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$("#OrderPopup").modal("hide");
	function Value(orderlist) {
		$("#orderlist").val(orderlist);
		window.location = "vieworders";
	}
	</script>
	<script >
          function reroute(){
        	  windows.locartion.href=Url.Action("vieworders", "OrderController");
              }
	</script>
	<script type='text/javascript'>
	$("#OrderPopup").modal("hide");
function check() {
	$("#orderlist").val(orderlist);
	location.href = 'vieworders';
}
</script>
</script>
<script >
		setTimeout(function(){
			  $("#divID").remove();
			}, 3000);
		setTimeout(function(){
			  $("#divId").remove();
			}, 3000);
		
		</script>
</body>

</html>