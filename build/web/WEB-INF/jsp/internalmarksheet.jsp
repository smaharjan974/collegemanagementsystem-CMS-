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
                                        <h4 class="title"><b><center>Your MarkSheet</center></b></h4></div>
                                    <form >
                                        <div class="card-content table-responsive">
                                            Semester id: ${semid} <br><br>
                                            Roll : ${s.getRoll()}   <br><br>
                                            Name : ${s.getSfirstname()} ${s.getSlastname()}     <br><br>
                                            <table class="table" border="3">
                                                <tr bgcolor="C6FFCC" bordercolordark="#333333"> 
                                                    <th ">Subject Name</th>

                                                    <th  bgcolor="AAFFB1">Pass Marks</th>
                                                    <th>Full Marks</th>
                                                    <th  bgcolor="AAFFB1">Pratical Marks</th>
                                                    <th>Theory Marks</th>
                                                    


                                                </tr>

                                                <c:forEach items="${marksub}" var="x">
                                                    <tr>
                                                        <td>${x.getSubject().getSubjectcode()} ${x.getSubject().getSubjectname()}</td>
                                                        <td class='passmarks'>${x.getSubject().getPassmarks()}</td>
                                                        <td>${x.getSubject().getFullmarks()}</td>
                                                        <c:forEach items="${x.getMarks()}" var="y">
                                                            <td>${y.getInternalpratical()}</td>
                                                            <td class='marksobtain'>${y.getInternaltheory()}</td>
                                                            
                                                        </c:forEach>
                                                    </tr>
                                                </c:forEach>    
                                                 <tr bgcolor="C6FFCC" bordercolordark="#333333"> 
                                                    
                                                    <th colspan="3">Grand Total</th>
                                                    <th colspan='2' class="grandtotal">Sorry you have failed</th>
                                                    
                                                    


                                                </tr>


                                            </table>
                                        </div>
                                    </form>
                                            <center><font font-color="#ff0000"><strong>*Red= failed</strong>
                                                </font></center>
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

    <script type="text/javascript">
        $(document).ready(function () {
            var grandinternaltotal = 0;
            var grandtheorytotal = 0;
            $('.marksobtain').map(function() {
                var that = $(this);
                var theorymarks = Number(that.text());
                var passmarks = that.parent().find('.passmarks').text();
                var theorypassmarks = passmarks == '40' ? 32 : 16 ;
                if (theorymarks < theorypassmarks) {
                    that.addClass('failMarks');
                } else {
                    grandinternaltotal += Number(that.prev().text());
                    grandtheorytotal += theorymarks;
                }
            });
            
            var failpresent = $('.failMarks').length;
            
            if (failpresent === 0) {
                $('.grandtotal').text(grandtheorytotal + grandinternaltotal);
            }
            
            

        });
    </script>

</html>


