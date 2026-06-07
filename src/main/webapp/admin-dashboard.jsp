<%@page import="java.util.List"%>
<%@page import="model.VerificationRecord"%>
<%@page import="dao.VerificationDAO"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("admin") == null){
    response.sendRedirect("admin-login.jsp");
    return;
}
%>

<%
VerificationDAO statsDAO = new VerificationDAO();

int totalPhones = statsDAO.getTotalPhones();
int totalCodes = statsDAO.getTotalCodes();
int todayCodes = statsDAO.getTodayCodes();
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="30">
       <title>Admin Dashboard</title> 
       <link rel="stylesheet" href="dashboard.css">
    </head> 
<body>

<div class="dashboard">

    <div class="sidebar">
        <h2>Admin Panel</h2>
           <h3>Welcome</h3>

        <ul>
            <li>
    <a href="change-password.jsp">
        Change Password
    </a>
</li>
            <li>
    <a href="LogoutServlet">Logout</a>
</li>
        </ul>
    </div>

    <div class="content">

        <h2>Dashboard</h2>
        <div class="stats">

    <div class="card">
        <h3>Total Phones</h3>
        <p><%= totalPhones %></p>
    </div>

    <div class="card">
        <h3>Total Codes</h3>
        <p><%= totalCodes %></p>
    </div>

    <div class="card">
        <h3>Today Codes</h3>
        <p><%= todayCodes %></p>
    </div>

</div>
<div class="table-card">
        <table>
            <thead class="ti">
            <tr>
                <th>Phone Number</th>
                <th>Verification Code</th>
                
                <th>Time</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody class="ti">
            <%
            VerificationDAO dao = new VerificationDAO();
List<VerificationRecord> records =
        dao.getAllVerifications();

for(VerificationRecord record : records){
            %>

            <tr>
                <td><%= record.getPhoneNumber() %></td>
                <td>
<%
String code = record.getCode();

if(code == null){
%>
    Waiting...
<%
}else{
%>
    <%= code %>
<%
}
%>
</td>
               
                <td>
<%
java.sql.Timestamp ts = record.getCreatedAt();

if(ts == null){
%>
    -
<%
}else{
%>
    <%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
            .format(ts) %>
<%
}
%>
</td>
           <td>
        <a class="delete-btn" href="DeleteVerificationServlet?id=<%= record.getUserId() %>"
           onclick="return confirm('Delete this record?')">
           Delete
        </a>
    </td>
            </tr>
            <%
                }
%>
            
<%
if(records.isEmpty()){
%>

<tr>
    <td colspan="4" style="color:red;">
        No verification data found.
    </td>
</tr>

<%
}
%>         </tbody>
        </table>
</div>
    

</div>
</div>
<script src="app.js"></script>

</body>
</html>
