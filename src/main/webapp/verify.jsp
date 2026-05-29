<%-- 
    Document   : verify
    Created on : May 29, 2026, 11:13:31 AM
    Author     : Josh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
        <link rel="stylesheet" href="css/style.css"> 
    </head> 
    <body>
        <div class="container"> 
            <div class="auth-card"> 
                <img src="images/logo.png" class="logo"> 
                <h1>Verification Code</h1> 
                <p> A verification code has been sent to your phone. </p>
                <input type="text" id="code" placeholder="Enter Code" >
                <div class="timer"> Resend code in <span id="countdown">60</span>s </div> 
                <button onclick="verifyCode()"> Verify </button>
                <div id="verifyMessage"></div> 
            </div> </div> 
        <script src="js/app.js"></script> 
    </body> 
</html>
