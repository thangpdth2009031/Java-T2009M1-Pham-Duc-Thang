<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.User" %><%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body class="w3-container">
<div class="w3-panel w3-green">
    <h3>SUCCESS!</h3>
    <p>Đăng kí thành công </p>
</div>
<div>Thông tin tài khoản</div>
<div>Username: <%=user.getUsername()%></div>
<div>Full Name: <%=user.getFullName()%></div>
<div>Birthday: <%=user.getBirthday()%></div>
<div>Email: <%=user.getEmail()%></div>
<div>Phone: <%=user.getPhone()%></div>
</body>
</html>
