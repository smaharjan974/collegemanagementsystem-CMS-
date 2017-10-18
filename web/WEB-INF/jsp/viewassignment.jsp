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
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/style_entry.css" />
</head>

<body>
    <div class="panel panel-default">
        <div class="panel-heading"><h1><span class="glyphicon glyphicon-th-list"></span> List of Assignment</h1></div>
            <div class="panel-body">
                            
                            

                            
                          <form method="post" action="${pageContext.servletContext.contextPath}/addsemester" modelAttribute="semesterlist">    
            <div class="container">
                <p style="text-align:center;">Here, you'll add new assignment detail to record into database.</p>
            </div>
        
        <form >
        <center>
            <table border="1"><table class="table table-curved" border="3">
                <tr bgcolor="C6FFCC" bordercolordark="#333333">
                    <th bgcolor="AAFFB1">subject code</th>
                    <th>name</th>
                    <th bgcolor="AAFFB1">file</th>
                    <th>deadline</th>
                    <th bgcolor="AAFFB1">remarks</th>                    
                    <th>delete</th>
                </tr>
                
               

                
                    <c:forEach items="${list}" var="s">
                        <tr>   
                        
                        <td>${s.subjectcode}</td>
                        <td>${s.name}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/resources/assignment/${s.file}">${s.file}</a></td>
                        <td>${s.deadline}</td>
                        <td>${s.remarks}</td>
                        <td> <a href="${pageContext.servletContext.contextPath}/deleteassignment/${s.id}">delete</a></td>
                         </tr>
                    </c:forEach>
               </center>
            </table>
        </form>
                                        
                                        
                                    


           </form>
        </div>
 
</div>
</body>
</html>                    </div>
        </div>                
    </div>
        
        
</body>
</html>
