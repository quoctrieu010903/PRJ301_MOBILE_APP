<%-- 
    Document   : Login
    Created on : Apr 8, 2024, 9:22:28 AM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Animated Login Form</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <img class="wave" src="img/wave.png">
        <div class="container">
            <div class="img">
                <img src="img/bg.svg">
            </div>
            <div class="login-content">
                <form action="MainController" method="post">
                    <img src="img/avatar.svg">
                    <h2 class="title">Welcome</h2>
                    
                    <% 
                        String error = (String)request.getAttribute("ERROR"); 
                        if(error == null ) error="";    
                    %>
                    <p style="color: red; margin-bottom: 15px;"><%=error%></p>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>UserID</h5>
                            <input type="text" class="input" name="txtUserID">
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i"> 
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Password</h5>
                            <input type="password" class="input" name="txtPassword">
                        </div>
                    </div>
                    <a href="#">Forgot Password?</a>
                    <input type="submit" class="btn" value="Login" name="action">
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
