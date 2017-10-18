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
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/home.css" />
</head>
<c:if test="${sessionScope.adminusername==null}">
        <c:redirect url="/adminlogin"/>
    </c:if>
<body>
    <h3>hello ${adminusername}</h3>
    <div class="logout_btn">
        <a href="${pageContext.servletContext.contextPath}/logout" class="btn btn-primary btn-large">Logout <i class="icon-white icon-check"></i></a>
    </div>
    
  <div class="img_home_pos">
        <a href="${pageContext.servletContext.contextPath}/homepage"><img src="${pageContext.servletContext.contextPath}/resources/images/img21.jpg" height="90" alt="Info Vista CMS" /></a><span class="header_pos">Info Vista CMS</span>
    </div><br>
                        
                        <div class="dropdownmenu_container">
                            
<!--first button-->

                                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
                        Students <span class="caret"></span> 					
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addstudent">Students Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewstudent">View Students</a></li>
                    </ul>
                </div>

                <!--second button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
                        Teachers <span class="caret"></span> 					
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addteacher">Teachers Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewteacher">View Teachers</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/subjectteacher">Teacher Subject Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewsubjecttaught">View Teacher Subject</a></li>

                    </ul>
                </div>

                <!--third button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-hdd"></span>
                        Faculties <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addfaculty">Faculties Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewfaculty">View Faculties</a></li>
                    </ul>
                </div>

                <!--forth button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-th-list"></span>
                        Subjects <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addsubject">Subjects Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewsubject">View Subjects</a></li>
                    </ul>
                </div>

                <!--fifth button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-star-empty"></span>
                        Event <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addevent">Event Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewevent">View Entry</a></li>
                    </ul>
                </div>



                <!--seventh button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-globe"></span>

                        Batch <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addbatch">Batch Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewbatch">View Batch</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/addbatchsem">Entry Batch Semester </a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewbatchsem">View Batch Semester </a></li>
                    </ul>
                </div>

                <!--eaigth button-->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Semester <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/addsemester">Semester Entry</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewsemester">View Semester</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/viewbatchsemsub">View Semester Subject</a></li>
                    </ul>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Marks <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/choosemarks">View Marks</a></li>

                    </ul>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Attendance <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/attend">View Attendance</a></li>

                    </ul>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Marks Prediction <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/prediction">View Attendance</a></li>

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
        <div class="panel-heading"><h1><center><span class="glyphicon glyphicon-th-list"></span>View Event</center></h1></div>
<!DOCTYPE html>
<html>
    
    <body>
       
    <center>
        <table border="1">
            <tr bgcolor="C6FFCC" bordercolordark="#333333">
                <th>Name of Event</th>
                <th bgcolor="AAFFB1">Type of event</th>
                <th>Date</th>
                <th bgcolor="AAFFB1">Venue</th>
                <th>Images</th>
                <th bgcolor="AAFFB1">Details</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${list}" var="x">
                <tr>
                    <td>${x.name}</td>
                    <td>${x.type}</td>
                    <td>${x.date}</td>
                    <td>${x.venue}</td>
<!--                    <td><a href="${pageContext.servletContext.contextPath}/${pageContext.servletContext.contextPath}/resources/eventimage/${x.images}">${x.images}</a></td>-->
                    <td><img src="${pageContext.servletContext.contextPath}/${pageContext.servletContext.contextPath}/resources/eventimage/${x.images}" height="500%" width="700%"></td>
                    <td>${x.details}</td>
                    <td><a href="${pageContext.servletContext.contextPath}/deleteevent/${x.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        
    </center>
    </body>
</html>
