<%-- 
    Document   : viewfaculty
    Created on : Jun 18, 2017, 8:24:29 PM
    Author     : SANJAY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance View</title>
        <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.1.11.1.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/home.css" />
    </head>
    <body>
        <h1>The list of Attendance</h1>
        
        <form action="${pageContext.servletContext.contextPath}/editmarks" method="get">
            <center>
                Semester id: ${semesterid}<br>
                Subjectcode : ${subjectcode}<br>
            <table border="1">
                <tr>
                    
                    <th>roll</th>
                    <th>Name</th>
                        <c:forEach items="${date}" var="x">
                        <th>${x}</th>
                        </c:forEach>
                       
                  
                </tr>
                
                    <c:forEach items="${atlist}" var="x">
                        <tr class="check">   
                            <td>${x.getS().getRoll()} </td>
                            <td>${x.getS().getSfirstname()} ${x.getS().getSlastname()} </td>
                            <c:forEach items="${x.getAttendance()}" var="y">
                                <td>${y.getAttendance()}</td>
                            </c:forEach>
                         </tr>
                    </c:forEach>
                        
            </table>
           
        </form>
            <h3>*true = Present</h3>
            <h3>*false = Absent</h3>
             </center>
            
            <script>
                $(function() {
                    $('.check').find('td').map(function(){
                        var string = $(this).text();
                        if(string === 'false'){
                           $(this).addClass('failMarks');
                        }
                    });
                });
            </script>
    </body>
</html>
