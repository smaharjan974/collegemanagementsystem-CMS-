<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.servletContext.contextPath}/resources/assests/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="${pageContext.servletContext.contextPath}/resources/assests/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>College Management System</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="${pageContext.servletContext.contextPath}/resources/css/home.css" rel="stylesheet" />

    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.servletContext.contextPath}/resources/assests/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="${pageContext.servletContext.contextPath}/resources/assests/css/material-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.servletContext.contextPath}/resources/assests/css/demo.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>
<c:if test="${sessionScope.roll == null}">
    <c:redirect url="/studentlogin/" />
    
</c:if>
<body>
   

	<div class="wrapper">

	    <div class="sidebar" data-color="purple" data-image="${pageContext.servletContext.contextPath}/resources/assests/img/sidebar-1.jpg">
			<!--
		        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

		        Tip 2: you can also add an image using data-image tag
		    -->

			<div class="logo">
				
                            <center><font size="6" font-style="bold"><a href="${pageContext.servletContext.contextPath}/student"> ${firstname} ${lastname}</a><br><br>
                                    ${roll}</font></center>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	          
	                <li>
                            <a href="${pageContext.servletContext.contextPath}/student">
	                        <i class="material-icons">person</i>
	                        <p>User Profile</p>
	                    </a>
	                </li>
	                <li>
                            <a href="${pageContext.servletContext.contextPath}/marksheet">
	                        <i class="material-icons">content_paste</i>
	                        <p>Marks</p>
	                    </a>
	                </li>
	                <li>
	                    <a href="${pageContext.servletContext.contextPath}/attendances">
	                        <i class="material-icons">library_books</i>
	                        <p>Attendance</p>
	                    </a>
	                </li>
	                <li>
                            <a href="${pageContext.servletContext.contextPath}/assignment">
	                        <i class="material-icons">bubble_chart</i>
	                        <p>Assignment</p>
	                    </a>
	                </li>
	                
	                
	            </ul>
	    	</div>
	    </div>
<div class="main-panel">


		<nav class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						
					</div>
					<div class="collapse navbar-collapse">
                                            <center> <h2> Info Vista</h2></center>
						<ul class="nav navbar-nav navbar-right">
							<li>
                                                            <a href="${pageContext.servletContext.contextPath}/" >                                                                <input type="button" value="logout" class="btn btn-primary btn-block"></a>
                                                            
                                                               <p class="hidden-lg hidden-md">Profile</p>
	 						   </a>
							</li>
						</ul>
	   <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="green">
                                        <h4 class="title"><b><center>Your Attendance Sheet </center></b></h4></div>
                                    <center>
        <table border="1">
            <tr>
                <th>Subject Name</th>
                <th>Total days</th>
                <th>Present Days</th>
            </tr>
            <c:forEach items="${subt}" var="x">
                <tr>
                    <td>${x.getSubject().getSubjectname()}</td>
                    <td class="totaldays">${x.totaldays}</td>
                    <td class="totalpresent">${x.present}</td>
                </tr>
            </c:forEach>
        </table>
                                        <strong>*Red = less than 70% attendance</strong>
    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>




    </body>

    <!--   Core JS Files   -->
    <script src="${pageContext.servletContext.contextPath}/resources/assests/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/assests/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/assests/js/material.min.js" type="text/javascript"></script>

    <!--  Charts Plugin -->

    <script>
        $(function() {
            $('.totalpresent').map(function() {
                var that = $(this);
                var totalpresent = Number(that.text());
                var totaldays = Number(that.parent().find('.totaldays').text());
                var percent = (totalpresent/totaldays)*100;
                if(Math.floor(percent) < 70){
                    that.addClass('failMarks');
                }
                
            });
        });
    </script>

</html>




