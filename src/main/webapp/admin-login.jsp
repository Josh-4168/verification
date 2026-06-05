

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin login</title>
        <link rel="stylesheet" href="admin-login.css">
    </head>
    <body>
        <div class="login-card">
        <div class="auth-card">
    <h2>Admin Login</h2>
<%
if(request.getParameter("error") != null){
%>
    <p class="error-message">
        Invalid username or password
    </p>
<%
}
%>
    <form action="AdminLoginServlet" method="POST">

        <input type="text"
               name="username"
               placeholder="Username"
               required>

        <br><br>

        <input type="password"
               name="password"
               placeholder="Password"
               required>

        <br><br>

        <button type="submit">Login</button>

    </form>

</div>

        </div>     
    </body>
</html>
