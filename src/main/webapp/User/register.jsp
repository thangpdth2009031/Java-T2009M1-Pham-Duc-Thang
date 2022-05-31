<%@ page import="java.util.HashMap" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.Account" %>
<%HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");%>
<%
    Account account = (Account) request.getAttribute("account");
    if (account == null) {
        account = new Account();
        System.out.println(account);
    }
    if (errors != null) {
        for (String i : errors.keySet()) {
            System.out.println(errors.get(i));
        }
    }
%>
<%System.out.println(errors);%>


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }

        .valid {
            color: red;
            margin: 0 0 10px 0;
            font-size: 13px
        }
    </style>
</head>
<body>
<a href="<%= request.getRequestURI() %>/hello">Try Again</a>
<form action="/register" method="post">
    <div class="container">
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label><b>Username</b></label>
        <input type="text" style="margin: 5px 0" placeholder="Enter username" name="username" value="<%=account.getUsername()%>" id="username">
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("username")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>


        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password"  name="password" id="psw">
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("password")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("confirmPassword")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <label><b>Confirm Password</b></label>
        <input type="password" placeholder="Confirm Password" value="" name="confirmPassword">
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("confirmPwdNull")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <label><b>Full name</b></label>
        <input type="text" placeholder="Enter full name" value="<%=account.getFullName()%>" name="fullName" id="psw-repeat">
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("username")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <label><b>Email</b></label>
        <input type="text" placeholder="Full email" value="<%=account.getEmail()%>" name="email"/>
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("email")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("emailValid")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <label><b>Phone</b></label>
        <input type="text" placeholder="Enter Phone" value="<%=account.getPhone()%>" name="phone"/>
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("phone")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>
        <% if (errors != null) { %>
        <% for (String i : errors.keySet()) { %>
        <% if (i.equals("phoneValid")) { %>
        <p class="valid"><%=errors.get(i)%></p>
        <% } %>
        <% } %>
        <%}%>

        <label><b>Birthday</b></label>
        <input type="date" placeholder="Enter Birthday" value="<%=account.getBirthday()%>" name="birthday"/>
        <hr>
        <button type="submit" class="registerbtn">Register</button>
        <button type="reset" class="ui-helper-reset">Reset</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="#">Sign in</a>.</p>
    </div>
</form>

</body>
</html>


<%--<%@page import="validation.Myform" contentType="text/html" pageEncoding="UTF-8" %>--%>
<%--<jsp: useBean id="form"--%>
<%--      class="validation.Myform"--%>
<%--      scope="request">--%>
<%--    <jsp: setProperty name="form"--%>
<%--          property="errorMessages"--%>
<%--          value='<%= errorMap %>'/>--%>
<%--    </jsp:useBean>--%>
<%--    <html>--%>
<%--    <head>--%>
<%--    </head>--%>
<%--    <body bgcolor="green"><% if("true".equals(request.getParameter("process"))){%>--%>
<%--    <jsp: setProperty name="form"--%>
<%--          property="*"/>--%>
<%--    <%--%>
<%--        if (form.process()){--%>
<%--            HttpSession hs = request.getSession();--%>
<%--        hs.setAttribute("name",(String) request.getParameter("name"));--%>
<%--        hs.setAttribute("user",(String) request.getParameter("user"));--%>
<%--    %>--%>

<%--    <center>--%>
<%--        <form action='<%=request.getRequestURI()%>' method="POST">--%>
<%--            <table border="0">--%>
<%--                <tbody>--%>
<%--                <tr>--%>
<%--                    <td>Name</td>--%>
<%--                    <td><input type="text" name="name" value='<%=form.getName()%>'/></td>--%>
<%--                    <td><font color="red"> <%=form.getErrorMessage("name") %> < /font></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td> Username</td>--%>
<%--                    <td><input type="text"--%>
<%--                               name="user"--%>
<%--                               value='<%=form.getUser()%>'/></td>--%>
<%--                    <td><font color="red"> <%=form.getErrorMessage("user") %> < /font></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td> Password</td>--%>
<%--                    <td><input type="password"--%>
<%--                               name="pass1"--%>
<%--                               value='<%=form.getPass1(--%>
<%--                            )%>'/></td>--%>
<%--                    <td><font color="red"><%=form--%>
<%--                        .--%>
<%--                        getErrorMessage--%>
<%--                        (--%>
<%--                        "pass1"--%>
<%--                        ) %>--%>
<%--                    </font>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td> Re Enter Password</td>--%>
<%--                    <td><input type="password"--%>
<%--                               name="pass2"--%>
<%--                               value='<%=form.getPass2()%>'/></td>--%>
<%--                    <td><font color="red"> <%=form.getErrorMessage("pass2") %> < /font></td>--%>
<%--                </tr>--%>
<%--                </tbody>--%>
<%--            </table>--%>
<%--            <center><input type="submit"--%>
<%--                           value="Register Me"/></center>--%>
<%--            <input type="HIDDEN"--%>
<%--                   name="process"--%>
<%--                   value="true"/></form>--%>
<%--    </center>--%>
<%--    </body>--%>
<%--    </html>--%>
<%--        <%!--%>
<%--    // Define error messages--%>
<%--    java.util.Map errorMap = new java.util.HashMap();--%>
<%--    public void jspInit()--%>
<%--    {--%>
<%--        errorMap.put(Myform.ERR_NAME_BLANK, "PLEASE ENTER YOUR NAME");--%>
<%--        errorMap.put(Myform.ERR_USER_BLANK, "PLEASE ENTER YOUR USERNAME");--%>
<%--        errorMap.put(Myform.ERR_USER_LENGTH, "LENGTH SHOULD BE 5 OR MORE");--%>
<%--        errorMap.put(Myform.ERR_USER_EXISTS, "USERNAME ALREDY EXISTS");--%>
<%--        errorMap.put(Myform.ERR_PASS1_BLANK, "PLEASE ENTER YOUR PASSWORD");--%>
<%--        errorMap.put(Myform.ERR_PASS1_LENGTH, "LENGTH SHOULD BE 5 OR MORE");--%>
<%--        errorMap.put(Myform.ERR_PASS2_BLANK, "PLEASE RE ENTER YOUR PASSWORD");--%>
<%--        errorMap.put(Myform.ERR_PASS2_MATCH, "PASSWORD DOES NOT MATCH");--%>
<%--        errorMap.put(Myform.ERR_ADDRESS_BLANK, "PLEASE ENTER YOUR ADDRESS");--%>
<%--        errorMap.put(Myform.ERR_CONTACT_BLANK, "PLEASE ENTER YOUR MOBILE #");--%>
<%--        errorMap.put(Myform.ERR_CONTACT_LENGTH, "LENGTH SHOULD BE 10");--%>
<%--        errorMap.put(Myform.ERR_CONTACT_INVALID, "INVALID CONTACT #");--%>
<%--        errorMap.put(Myform.ERR_PIN_BLANK, "PLEASE ENTER YOUR PIN CODE");--%>
<%--        errorMap.put(Myform.ERR_PIN_LENGTH, "LENGTH SHOULD BE 6");--%>
<%--        errorMap.put(Myform.ERR_PIN_INVALID, "INVALID PIN CODE");--%>
<%--        errorMap.put(Myform.ERR_EMAIL_BLANK, "PLEASE ENTER YOUR EMAIL ID");--%>
<%--        errorMap.put(Myform.ERR_EMAIL_INVALID, "INVALID EMAIL ID");--%>
<%--    }--%>
<%--%>--%>