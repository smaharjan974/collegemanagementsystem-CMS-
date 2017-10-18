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
            
      <div class="panel panel-default">
          <div class="panel-heading"><h1><center><span class="glyphicon glyphicon-th-list"></span>Attendance of Faculty and Batch</center></h1></div>
          
</br>
</br>

  
 <tr>
 
      
    </body>
</html>



           
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/insertattendance" method="post" id="attendform">
                                        <div>
                                            Date: <input type="date" name="date" />
                                        </div>
                                        <br></br>
                                        <div>
                                            Subject code: ${sublist} <input type="text" value="${sublist}" hidden name="subjectcode"/> 
                                        </div>
                                        <div>
                                            Semester id: ${semlist} <input type="text" value="${semlist}"  name="semesterid" hidden/> 
                                        </div>
                                        <div>

                                            <table border="1">
                                                <tr>
                                                    <th>Roll</th>
                                                    <th>Name</th>
                                                    <th>Attendance <input type="checkbox" onClick="toggle(this)"/></th>
                                                    <th>Remarks</th>
                                                </tr>
                                                <c:forEach items="${stlist}" var="x">
                                                    <tr>
                                                        <td>${x.roll}<input type="text" value="${x.roll}" name="roll" hidden/> </td>
                                                        <td>${x.sfirstname} ${x.slastname}</td>
                                                        <td><center><input type="checkbox" name="attendance" id="${x.roll}" value="true" onchange="checkAttendance(this);"/><input type="text" name="attendance" id="${x.roll}hidden" value="false" hidden></center></td>
                                                        <td><input type="text" name="remarks" /></td>
                                                    </tr>
                                                </c:forEach>

                                            </table>
                                            <input type="button" id="btnadd" value="add" />
                                    </form>
                                </div>
                                </div>
                            </center>
                            <script language="JavaScript">
//                                $(function () {
                                function toggle(source) {
                                    checkboxes = document.getElementsByName('attendance');
                                    for (var i = 0, n = checkboxes.length; i < n; i++) {
                                        checkboxes[i].checked = source.checked;
                                    }
                                }
                                ;

                                function checkAttendance(event) {
                                    console.log($(event));
                                    if($(event).is(':checked')){
                                        console.log("checked true");
                                        $(event).attr('value', 'true');
                                    }else{
                                        $(event).attr('value', 'false');
                                    };
                                }

//                                });

                            </script>
                                        
                                        <script type="text/javascript">
                                            $(document).ready(function(){
                                                $("#btnadd").click(function(){
                                                    <c:forEach items="${stlist}" var="x">
                                                            if($("#${x.roll}").is(':checked')){
                                                                $("#${x.roll}hidden").attr('disabled',true);
                                                            }
                                                    </c:forEach>
                                                    $("#attendform").submit();
                                                });
                                            });
                                        </script>
                        </body>

                    </html>