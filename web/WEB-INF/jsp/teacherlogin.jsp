<%-- 
    Document   : studentlogincontroller
    Created on : May 27, 2017, 2:18:24 PM
    Author     : SANJAY
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Login Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/studentlogin.css"/>
    </head>
    <c:if test="${sessionScope.teacherid!= null}">
    <c:redirect url="/teacherhomepage" />
</c:if>
    <body>
         <div class="container">
        <div class="card card-container">
            <h2 >Teacher Login</h2>
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="${pageContext.servletContext.contextPath}/teacherlogin" method="post" >
                <span id="reauth-email" class="reauth-email"></span>
                <input id="inputEmail" name="teacherid" class="form-control" placeholder="Teacher ID" required >
                <input type="password" name="tpassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" href="#" type="submit">Sign in</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    </body>
</html>
