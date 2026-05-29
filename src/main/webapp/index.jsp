<%-- 
    Document   : index
    Created on : May 29, 2026, 11:14:15 AM
    Author     : Josh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Telegram Verification</title> 
        <link rel="stylesheet" href="css/style.css">
    </head> 
    <body> <div class="theme-toggle"> 
            <button onclick="toggleTheme()">🌙</button>
        </div> <div class="container"> <div class="auth-card"> 
                <img src="images/logo.png" class="logo"> 
                <h1>Sign in to Telegram</h1> 
                <p>Please confirm your country code and enter your phone number.</p> 
                <div class="phone-group"> 
                    <select id="countryCode">
                        <option value="+1">+1 USA</option>
                        <option value="+251">+251 Ethiopia</option> 
                        <option value="+44">+44 UK</option> 
                    </select> 
                    <input type="text" id="phone" placeholder="Phone Number" > 
                </div> 
                <button onclick="submitPhone()"> Next </button> 
                <div id="message"></div> 
            </div> </div> 
        <script src="js/app.js"></script> 
    </body> 
</html>
