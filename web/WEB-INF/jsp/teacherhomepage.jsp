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
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/home.css"/>
<title>College management system made by Rajendra Arora..</title>
</head>

<body>
	<div class="panel panel-default">
  		<div class="panel-heading"><h1>Info vista</h1></div>
                <div class="panel-body"><br><br>
        <div>
            <img src="${pageContext.servletContext.contextPath}/resources/images/rtupic.jpg" width="855" style="text-align: center;" height="308" onmousedown="return false;"  />
        </div><br><br>
        <div class="middle_text">
            <p><strong></strong></p>
        </div>
          <div class="text_para_home">
            <p>The world has developed a lot since it came first into existence with the development of science and technology. And the role of computers and information technology has been tremendous in the development of the world. So to make the world even better to live in, the computer is being used extensively in every field of human civilization. With the view to aid a bit in the development, we are going to develop the software on title "Info Vista" as our major project.
            Info Vista is a java based web application built with the view to facilitate the database management procedure occurring in any college and organization. This project keeps the record of all students, teachers and other staffs as well as provide some facilities to its teachers, students or others staffs with modifications they expect. Themain aim of this project is to provide the details of students, teachers and other staffs. This project keeps the record of day to day activities of all the students and teachers. This project is specially designed to reduce the consumption of time during the records of the students. And every parents can knew the details of their children. This project provides the details of event on college, routine, mark sheet and attendance of every students. 
            Info Vista has 3 users (Administrator, Teachers and Students). The main role is given to Administrator. All the data will be handled by Administrator. Administrator will add students, teachers, publish events, notice and others. This project provide timely information about data processing through the creation and retrieval of records for students, teachers and others in centralized database specific to a single component, or groups of components.
            
            
            </p>         
        </div>   
                </div>
        </div>
    
    
</body>
</html>                    </div>
		</div>                
	</div>
        
        <div class="bottom_pos">
           <a href="#" style="text-decoration: none;">About management</a>
        </div>
</body>
</html>