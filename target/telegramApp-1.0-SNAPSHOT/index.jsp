

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Verification</title> 
        <link rel="stylesheet" href="style.css">
    </head> 
    <body> <div class="theme-toggle"> 
            <button onclick="toggleTheme()">🌙</button>
        </div> 
      
         <form action ="PhoneSubmitServlet" method ="POST">
        <div class="container">
            <div class="auth-card"> 
                 
                <h1>Sign in to UNICEF Ethiopia</h1> 
                  <%
if(request.getParameter("error") != null){
%>
<p style="color:red;">
    Phone number must start with 7 or 9 and contain exactly 9 digits.
</p>
<%
}
%>
                <p>Please  enter your phone number.</p> 
               
                <div class="phone-group"> 
                    <select id="countryCode"  name="countryCode">
                       
                        <option value="+251">+251 </option> 
                        
                    </select> 
                    <input type="text" name="phone" id="phone" placeholder="Phone Number"  >
                </div> 
                <button type="submit"> Next </button> 
                <div id="message"></div> 
            </div> </div> 
</form>
        <script src="app.js"></script> 
    </body> 
</html>
