<%
if(session.getAttribute("admin") == null){
    response.sendRedirect("admin-login.jsp");
    return;
}
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>change password</title>
        <link rel ="stylesheet" href ="change-password.css">
    </head>
    <body>

<div class="password-card">

    <h2>Change Password</h2>
<%
if("1".equals(request.getParameter("success"))){
%>
<p style="color:lime;">Password changed successfully.</p>
<%
}
%>

<%
if("wrongpassword".equals(request.getParameter("error"))){
%>
<p style="color:red;">Current password is incorrect.</p>
<%
}
%>
    <form action="ChangePasswordServlet" method="POST">

        <input type="password"
               name="oldPassword"
               placeholder="Current Password"
               required>

        <input type="password"
               name="newPassword"
               placeholder="New Password"
               required>

        <button type="submit">
            Change Password
        </button>

    </form>

    <a href="admin-dashboard.jsp" class="back-link">
        Back to Dashboard
    </a>

</div>

</body>
</html>
