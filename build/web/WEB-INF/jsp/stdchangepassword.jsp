<%-- 
    Document   : stdchangepassword
    Created on : Aug 5, 2017, 9:48:58 AM
    Author     : SANJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="${pageContext.servletContext.contextPath}/changepassword" method="post">
        Old Password: <input type="password" name="oldpass"><br>
        New Password: <input type="password" name="newpass"><br>
        Confirm Password: <input type="password" name="confirmpass"><br>
        <input type="submit" value ="update">
        </form>
        
    </body>
</html>
