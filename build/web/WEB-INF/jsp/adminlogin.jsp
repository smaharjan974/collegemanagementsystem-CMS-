<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.lang.Exception"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.css.map"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.css.map"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/login.css" />
<title>Welcome to InfoVista CMS</title>
</head>
<c:if test="${sessionScope.adminusername!=null}">
        <c:redirect url="/homepage"/>
    </c:if>

<body>
   
	<div class="container">
    	<div class="container2">
    		<div class="h1_pos">
    			<h1>College authorities for only staff members. </h1>
    		</div><br><br><br>
                            <form action="${pageContext.servletContext.contextPath}/adminlogin" method="post" name="adminlogin">
                    <input type="text" class="form-control" name="adminusername" placeholder="Username" title="Enter username here" /><br>
                    <input type="password" class="form-control" name="adminpassword" placeholder="Password" title="Enter username here" /><br>
    		<input type="submit" href="#" class="btn btn-default" name="btn_log" value="Sign in" style="float: right;"/>
    		<div class="about_pos">
    			<a href="${pageContext.servletContext.contextPath}/resources/http://www.about.me/rajendraarora16" style="text-decoration:none; color: silver">About management</a>
    		</div>
    		</form>
    	</div>
    </div>
	
        <h2 style="color: #3a28a5; text-align: center;">
                    </h2>    
</body>
</html>