<%-- 
    Document   : admin-dashboard
    Created on : May 29, 2026, 11:15:06 AM
    Author     : Josh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Admin Dashboard</title> 
       <link rel="stylesheet" href="css/style.css">
    </head> <body> <div class="dashboard">
            <div class="sidebar"> 
                <h2>Admin Panel</h2>
                <ul>
                    <li>Dashboard</li>
                    <li>Verification Requests</li>
                    <li>Generate Codes</li> 
                    <li>Logout</li> 
                </ul> 
            </div> 
            <div class="main-content">
                <h1>Generate Verification Code</h1>
                <div class="generate-box"> 
                    <input type="text" id="adminPhone" placeholder="Phone Number" > 
                    <input type="text" id="adminCode" placeholder="Verification Code" >
                    <button onclick="generateCode()"> Generate </button> </div>
                <div id="adminMessage"></div> </div> </div> 
        <script src="js/app.js"></script>
    </body> 
</html>
