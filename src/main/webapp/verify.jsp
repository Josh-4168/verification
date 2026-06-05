

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
        <link rel="stylesheet" href="style.css"> 
    </head> 
    <body>
        <form action="VerifyCodeServlet" method ="post">
        <div class="container"> 
            <div class="auth-card"> 
                 
                <h1>Verification Code</h1> 
                <%
if(request.getParameter("error") != null){
%>

<p style="color:red">
    Invalid verification code
</p>

<%
    
}
%>
                <p> A verification code has been sent to your phone.check your notification. </p>
                <input type="text" name="code" placeholder="Enter Code" >
                <div class="timer"> Resend code in <span id="countdown"></span> </div> 
                <div id="resendText" onclick="resendCode()" style="color:gray; cursor:not-allowed;">
    Resend code
</div>
                <button type="submit"> Verify </button>
                <div id="verifyMessage"></div> 
            </div> </div> 
        </form>
        <script src="app.js"></script> 
    </body> 
</html>
