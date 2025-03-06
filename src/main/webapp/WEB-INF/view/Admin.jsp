<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../image/ex1.png" />
    <title>Login</title>  
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Ubuntu:wght@500&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
 <nav>
        <div class="logo">
           <p>main</p>
        </div>

                <ul>
                    <li><a href="/">HOME</a></li>
                    <li><a href="login">Log In</a></li>
                    <li><a href="register">Register</a></li>
                    

                </ul>
    </nav>
    <div class="background">
        <div class="blur"></div>
    </div>


    <form class="btn" action="AdminLogin" method="post">
        <table >
            <tr>
                <th> <label for="Aname">Admin Name<span style="color: red;">*</span></label><br>
                    <input type="text" id="aname" name="aname" ><br>
                </th>
            </tr>
            <tr>
                <th> <label for="password">Admin Password<span style="color: red;">*</span></label><br>
                    <input type="password" name="password" id="password"> <br>
                </th>
            </tr>
            
       
        </table> <br> 
        <div style="color: #FF0000;">${errorMessage}</div><br>
        <input type="submit" value="Submit">
    </form>

<div id="bottom-container">


    <p class="ftext">Copyright @ main</p>



</div>

</body>
</html>