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
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>Faculty view</title>
                </head>
                <body>
                    </br>
                    </br>
                    <div class="panel panel-default">
                        <div class="panel-heading"><h1><center><span class="glyphicon glyphicon-th-list"></span>View Marks with subject </center></h1></div>
                        <div class="panel-body">

                            <form >
                                <table class="table table-curved" border="3" >
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333">
                                        <th bgcolor="AAFFB1">Roll</th>
                                        <th bgcolor="AAFFB1">Name</th>
                                            <c:forEach items="${subname}" var="x">
                                            <th bgcolor="AAFFB1" colspan="2">${x.subjectcode} / ${x.subjectname}</th>
                                            </c:forEach>

                                    </tr>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='pass-marks'>
                                        <td bgcolor="AAFFB1"></td>
                                        <td bgcolor="AAFFB1"></td>
                                        <c:forEach items="${subname}" var="x">
                                            <td>Pratical</td>
                                            <td class="passmarks" data-pass="${x.getPassmarks()}">Theory</td>
                                            </c:forEach>

                                    </tr>
                                    <c:forEach items="${marks}" var="x">
                                        <tr class='individualMarks' >
                                            <td>${x.getStudent().getRoll()}</td>
                                            <td>${x.getStudent().getSfirstname()} ${x.getStudent().getSlastname()}</td>
                                            <c:forEach items="${x.getMark()}" var="y">
                                                <td>${y.finalpratical} </td>
                                                <td class="theorymarks">${y.finaltheory}</td>
                                            </c:forEach>

                                        </tr>   
                                    </c:forEach>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='totalStudent'>
                                        <th colspan="2">Total no. Of Students</th>
                                        <c:forEach items="${subname}" var="x">
                                        <td colspan='2'>
                                        </td>
                                            </c:forEach>
                                    </tr>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='totalpass'>
                                        <th colspan='2'>Total no. of Pass</th>
                                        <c:forEach items="${subname}" var="x">
                                        <td colspan='2'>
                                        </td>
                                            </c:forEach>
                                    </tr>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='totalfail'>
                                        <th colspan='2'>Total no. of Fail</th>
                                        <c:forEach items="${subname}" var="x">
                                        <td colspan='2'>
                                        </td>
                                            </c:forEach>
                                    </tr>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='higestmarks'>
                                        <th colspan='2'>Highest Marks</th>
                                        <c:forEach items="${subname}" var="x">
                                        <td colspan='2'>
                                        </td>
                                            </c:forEach>
                                    </tr>
                                    <tr bgcolor="C6FFCC" bordercolordark="#333333" class='avgmarks'>
                                        <th colspan='2'>Average Marks</th>
                                        <c:forEach items="${subname}" var="x">
                                        <td colspan='2'>
                                        </td>
                                            </c:forEach>
                                    </tr>
                                </table>
                            </form>
                            
                        </div>
                    </div>
                    <script>
                        $(function() {
                          var theoryMarks = $( ".theorymarks" );
                          var noOfSub = $('tbody tr').first().find('th').length - 2;
   
                          theoryMarks.map(function(index,value) {
                              var theoryvalue = $(value).text() || 0;
                              var idx = $(this).parent().find('td').index($(this));
                              var passMark = $('.pass-marks').find('td').eq(idx).data('pass');
                              var passCri = passMark === 40 ? 32 : 16;
                              
                              if(theoryvalue < passCri) {
                                  $(this).addClass('failMarks');
                              }  
                          });
                          
                     
                          var loop = 1;
                          for (var i= 1; i <= noOfSub ; i++ ) {
                             var totalStudent = 0;
                             var totalFail = 0;
                             var totalPass = 0;
                             var marks = [];
                             $('.individualMarks').map(function() {
                                var markspresent = $(this).find('td').eq(loop + 2).text();

                                if (markspresent) {
                                    totalStudent ++;
                                    marks.push(Number(markspresent));
                                }
                                
                                if (markspresent && $(this).find('td').eq(loop + 2).hasClass('failMarks')) {
                                    totalFail ++;
                                }
                                
                                if (markspresent && !$(this).find('td').eq(loop + 2).hasClass('failMarks')) {
                                    totalPass ++;
                                }
                                
                                
                                
                            });
                            loop = loop + 2;
                            
                            $('.totalStudent td').eq(i-1).text(totalStudent);
                            $('.totalpass td').eq(i-1).text(totalPass);
                            $('.totalfail td').eq(i-1).text(totalFail);
                            $('.higestmarks td').eq(i-1).text(Math.max(...marks));
                            $('.avgmarks td').eq(i-1).text((marks.reduce((a, b)=>a+b) / totalStudent));
                            }
                          
                         });
                    </script>
                </body>
            </html>
