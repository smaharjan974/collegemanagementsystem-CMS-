<%-- 
    Document   : assignment
    Created on : Aug 3, 2017, 9:36:51 PM
    Author     : SANJAY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Assignment and Note</h1>
        <table border="1">
            <tr>
                <th>Teacher Name</th>
                <th>Subject Name</th>
                <th>Name of Assignment</th>
                <th>File</th>
                <th>Deadline</th>
                <th>Remarks</th>
            </tr>
            <c:forEach items="${assign}" var="x">
                <tr>
                    <td>${x.getTeacher().getTfirstname()} ${x.getTeacher().getTlastname()}</td>
                    <td>${x.getSubject().getSubjectname()} (${x.getSubject().getSubjectcode()})</td>
                    <c:forEach items="${x.getDetails}" var="y">
                        <td>${y.name}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/resources/assignment/${y.file}">Download File</a></td>
                        <td>${y.deadline}</td>
                        <td>${y.remarks}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
