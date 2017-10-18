<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Welcome to College Management system</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="jquery-1.11.0.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/home.css" />
</head>
<c:if test="${sessionScope.teacherid==null}">
    <c:redirect url="/teacherlogin/" />
</c:if>
<body>
    <h3>${teacherid}</h3>
    <div class="logout_btn">
        <a href="${pageContext.servletContext.contextPath}/teacher/logout" class="btn btn-primary btn-large">Logout <i class="icon-white icon-check"></i></a>
    </div>
    
    <div class="img_home_pos">
        <a href="everyone.php"><img src="${pageContext.servletContext.contextPath}/resources/images/img21.jpg" height="90" alt="Rajasthan technical university" /></a><span class="header_pos">Info vista</span>
    </div><br>
                        
                        <div class="dropdownmenu_container">
                            
<!--first button-->

                                <div class="btn-group">
  					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
  					  Assignment <span class="caret"></span> 					
  					</button>
  				<ul class="dropdown-menu" role="menu">
                                    <li><a href="${pageContext.servletContext.contextPath}/addassignment">Assignment Entry</a></li>
  				  <li><a href="${pageContext.servletContext.contextPath}/viewassignment">Assignment view</a></li>
  				</ul>
				</div>
				
				<!--second button-->
				<div class="btn-group">
  					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
  					  Attendance <span class="caret"></span> 					
  					</button>
  				<ul class="dropdown-menu" role="menu">
                                    <li><a href="${pageContext.servletContext.contextPath}/attendance">Attendance Entry</a></li>
                                    <li><a href="${pageContext.servletContext.contextPath}/viewattendance">Attendance view</a></li>
  				</ul>
				</div>
				
				<!--third button-->
				<div class="btn-group">
  					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-hdd"></span>
  					  Marks <span class="caret"></span>
  					</button>
  				<ul class="dropdown-menu" role="menu">
                                    <li><a href="${pageContext.servletContext.contextPath}/addmarks">Marks entry</a></li>
  				  <li><a href="${pageContext.servletContext.contextPath}/marksview">Marks view</a></li>
  				</ul>
				</div>
				
				
				     
                                                       </div>
		
		<div class="container_middle">		
			
			<div class="container_show_post">
				<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
<title>College management system made by Rajendra Arora..</title>
</head>

<body>
<center>
            <
      <div class="panel panel-default">
          <div class="panel-heading"><h1><center><span class="glyphicon glyphicon-th-list"></span>Choose Attendance of Faculty and Batch</center></h1></div>
          
</br>
</br>

  <font size="+2">
  <table bordercolorwhite="icon-white">
 <tr>
 
      
    </body>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/home.css"/>
<title>College management system made by Rajendra Arora..</title>
</head>

<body>
<center>
    <form action="${pageContext.servletContext.contextPath}/addattendance" method="post" >
        <div class="btn-group">
            <select name="subjectcode">
                <option >Select subjectcode</option>
                <c:forEach items ="${list}" var="x">
                    <option value="${x.subjectcode}">${x.subjectcode}</option>
                </c:forEach>
                    
            </select></div><br>
    
       <div class="btn-group">
            <select name="batchid">
                <option >Select batchid</option>
                <c:forEach items ="${list}" var="x">
                    <option value="${x.batchid}">${x.batchid}</option>
                </c:forEach>
            </select></div><br>
    
    <div class="btn-group">
            <select name="facultyid">
                <option >Select facultyid</option>
                <c:forEach items ="${list}" var="x">
                    <option value="${x.facultyid}">${x.facultyid}</option>
                </c:forEach>
            </select></div><br>
                
                
                    <input type="submit" value="search" /> 
                </form>
                
        </center>
        <span>${param.msg}</span>
</body>
</html>


