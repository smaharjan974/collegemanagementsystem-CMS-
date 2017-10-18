<%-- 
    Document   : forgotpassword
    Created on : Aug 5, 2017, 4:14:00 PM
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
        <form action="${pageContext.servletContext.contextPath}/student/forgetpassword" method="post">
            Enter your Username : <input type="text" name="roll">
        <br>
        Enter your username : <input type="text" name="email">
        
        <input type="submit" value="Submit"> 
        <input type="reset" value="cancel">
        </form>
    </body>
</html>
