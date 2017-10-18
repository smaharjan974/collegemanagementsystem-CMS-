
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
                
                
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty view</title>
    </head>
    <body>
            <form action="${pageContext.servletContext.contextPath}/showmarksdetails" method="post">

      

        
        </div></form>
        <div class="panel panel-default">
        <div class="panel-heading"><h1><center><span class="glyphicon glyphicon-th-list"></span>View marks of Faculty and Batch</center></h1></div>
                <div class="panel-body"><br><br>
        <div>
        <form action="${pageContext.servletContext.contextPath}/editmarks" method="get">
        <center>
            <table border="1">
                <tr bgcolor="##00FF00">
                    
                    <th bgcolor="#46C646">roll</th>
                    <th>Semesterid</th>
                    <th bgcolor="#46C646">subjectcode</th>                  
                    <th>internal pratical</th>
                    <th bgcolor="#46C646">internal theory</th>
                     <th>final pratical</th>
                    <th bgcolor="#46C646">final theory</th>
                    <th>edit</th>
                  
                </tr>
                
                    <c:forEach items="${markslist}" var="s">
                        <tr>   
                            <td>${s.roll} <input type="text" value="${s.roll}" name="roll" hidden /></td>
                        <td>${s.semesterid} <input type="text" value="${s.semesterid}" name="semesterid" hidden/></td>
                        <td>${s.subjectcode} </td>
                        <td>${s.internalpratical} <input type="text" value="${s.internalpratical} " hidden/></td>
                        <td>${s.internaltheory} <input type="text" value="${s.internaltheory}" hidden/></td>
                        <td>${s.finalpratical} <input type="text" value="${s.finalpratical}" hidden/></td>
                        <td>${s.finaltheory} <input type="text" value="${s.finaltheory}" hidden/></td>
                        <td><a href="${pageContext.servletContext.contextPath}/marksedit/${s.id}">edit</a></td>
                         </tr>
                    </c:forEach>
                        
            </table>
            </center>
            <center>
             <input type="submit" value="Edit" />
             </center>
        </form>
    </body>
</html>
