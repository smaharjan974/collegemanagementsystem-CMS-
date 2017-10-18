<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
        <title>Welcome to College Management system</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="jquery-1.11.0.js"></script>
        <script type="text/javascript">

function check_info(){
	
	var firstn=document.getElementById("fn").value;
	var lastn=document.getElementById("ln").value;
	var bld=document.getElementById("bg").value;
	var gender1=document.getElementById("gm").checked;
    var gender2=document.getElementById("gf").checked;
	var roll=document.getElementById("rol").value;
	var address=document.getElementById("adrs").value;
	var number=document.getElementById("no").value;
	var email=document.getElementById("ea").value;
	var password=document.getElementById("pw").value;
	var gfirstn=document.getElementById("gfn").value;
	var glastn=document.getElementById("gln").value;
	var grelation=document.getElementById("gr").value;
	var gcontact=document.getElementById("gc").value;
	var gemail=document.getElementById("ge").value;
	var numcheck=/^[0-9]+$/;
	
	
	
			   	if(gfirstn=="")
	{
		
		alert("Please insert the Guardian FirstName");
		return false;
	}
				   	if(glastn=="")
	{
		
		alert("Please insert the Guardian LastName");
		return false;
	}
				   	if(grelation=="")
	{
		
		alert("Please insert the relation between  guardian and student");
		return false;
	}
				   	if(gcontact=="")
	{
		
		alert("Please insert the Guardian Contact number");
		return false;
	}
        
        var regex = /^(9779(8|7)\d{8})|(9(8|7)\d{8})$/;
    if (!regex.test(gcontact)) {
    alert("insert valid guradian contact number");
        return false;
    }
        
				   	if(gemail=="")
	{
		
		alert("Please insert the Guardian email ID");
		return false;
	}
	
	
	if(f.bloodgroup.selectedIndex==0){
			alert("Please select bloodgroup");
		return false;
		}
		
		
		if(f.facultyid.selectedIndex==0){
			alert("Please select faculty");
		return false;
		}
		
			if(f.batchid.selectedIndex==0){
			alert("Please select batch");
		return false;
		}
		
			if(roll=="")
	{
		
		alert("Please insert the roll number");
		return false;
	}
	   	if(address=="")
	{
		
		alert("Please insert the address");
		return false;
	}

		   	if(number=="")
	{
		
		alert("Please insert the contact number");
		return false;
	}
	
	var regex = /^(9779(8|7)\d{8})|(9(8|7)\d{8})$/;
    if (!regex.test(number)) {
    alert("insert valid number");
        return false;
    }
	
	
		   	if(email=="")
	{
		
		alert("Please insert the Email address");
		return false;
	}
		   	if(password=="")
	{
		
		alert("Please insert the password");
		return false;
	}
	
	if(firstn=="")
	{
		
		alert("Please insert the firstname");
		return false;
	}
	if(lastn==""){
		alert("Please insert the form lastname");
		return false;
		}
		if((gender1=="")&&(gender2=="")){
			alert("Please insert the gender");
		return false;
			}
	
	else{
		return true;
	}
	
}
</script>


        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/table.css"/>

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

        <div class="logout_btn">
            <a href="${pageContext.servletContext.contextPath}/logout" class="btn btn-primary btn-large">Logout <i class="icon-white icon-check"></i></a>
        </div>

        <div class="img_home_pos">
            <a href="everyone.php"><img src="${pageContext.servletContext.contextPath}/resources/images/img21.jpg" height="90" alt="Rajasthan technical university" /></a><span class="header_pos">Rajasthan Technical University</span>
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
                        <li><a href="${pageContext.servletContext.contextPath}/viewevent">View Score</a></li>
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
                    </ul>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Marks <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/viewmarks">View Marks</a></li>

                    </ul>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span>
                        Attendance <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.servletContext.contextPath}/vieattendance">View Attendance</a></li>

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
                                <div><h1><span class="glyphicon glyphicon-user"></span> Student Entry Form</h1></div>
                                <div class="panel-body">
                                    <div class="container">
                                        <p style="text-align:center;">Here, you'll add new student's detail to record into database.</p>
                                    </div>

                                    <div class="container_form">
                                        <form method="post" action="${pageContext.servletContext.contextPath}/addstudent" onsubmit="return check_info();" name="f" >
                                            <div class="teacher_name_pos">
                                                First Name<input type="text" name="sfirstname" class="form-control" placeholder="First name" id="fn" />
                                                Last Name<input type="text" name="slastname" class="form-control" placeholder="Last name" id="ln" />
                                            </div><br>

                                                <div class="teacher_radio_pos">
                                                    <input type="radio" name="sgender" value="Male" id="gm" /> <span class="p_font">&nbsp;Male</span>
                                                    <input type="radio" name="sgender" value="Female" id="gf" /> <span class="p_font">&nbsp;Female</span>
                                                </div><br>

                                                    <div class="teacher_bday_box">

                                                        <div class="select_style">
                                                            Date Of Birth   <input type="date" name="sDOB" id="dob" />
                                                        </div><br></br>

                                                    </div><br><br>

                                                            <div>
                                                                Blood Group:
                                                                <select name="bloodgroup" id="bg">
                                                                    <option value="" name="bloodgroup" ></option>
                                                                    <option value="A+" name="bloodgroup" >A+</option>
                                                                    <option value="A-" name="bloodgroup" >A-</option>
                                                                    <option value="B+" name="bloodgroup">B+</option>
                                                                    <option name="bloodgroup" value="B-">B-</option>
                                                                    <option name="bloodgroup" value="AB+">AB+</option>
                                                                    <option name="bloodgroup" value="AB-">AB-</option>
                                                                    <option name="bloodgroup" value="O+">O+</option>
                                                                    <option name="bloodgroup" value="O-">O-</option>
                                                                </select>		
                                                            </div><br><br>



                                                                    <div class="teacher_address_pos">

                                                                        Faculty : <select name="facultyid">
                                                                            <option>select faculty</option>
                                                                            <c:forEach items="${facultylist}" var="faculty">
                                                                                <option name="facltyid" value="${faculty.facultyid}" >${faculty.facultyid}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div><br>


                                                                        <div class="teacher_address_pos">
                                                                            Batch id : <select name="batchid">
                                                                                <option>select faculty</option>
                                                                                <c:forEach items="${batchlist}" var="batch">
                                                                                    <option name="batchid" value="${batch.batchid}" >${batch.batchid}</option>
                                                                                </c:forEach>
                                                                            </select></div><br>

                                                                            <div class="teacher_address_pos">
                                                                                <input type="text" name="roll" class="form-control" placeholder="Roll" id="rol" />
                                                                            </div><br>





                                                                                <div class="teacher_address_pos">
                                                                                    <input type="text" name="saddress" class="form-control" placeholder="Address" id="adrs" />
                                                                                </div><br>

                                                                                    <div class="teacher_mobile_pos">
                                                                                        <input type="text" name="scontact" class="form-control" placeholder="Mobile no." id="no" />
                                                                                    </div><br>

                                                                                        <div class="teacher_mail_pos">
                                                                                            <input type="text" name="semail" class="form-control" placeholder="Email address" id="ea" />
                                                                                        </div><br>

                                                                                            <div class="teacher_mail_pos">
                                                                                                <input type="text" name="password" class="form-control" placeholder="password" id="pw" />
                                                                                            </div><br>





                                                                                                <div  >

                                                                                                    <h1><span class="glyphicon glyphicon-user"> </span> Guardains Entry Form</h1></div>

                                                                                                <div class="teacher_name_pos">
                                                                                                    <input type="text" name="gfirstname" class="form-control" placeholder="First name" id="gfn" />

                                                                                                    <input type="text" name="glastname" class="form-control" placeholder="Last name" id="gln" />
                                                                                                </div><br>

                                                                                                    <div class="teacher_name_pos">
                                                                                                        <input type="text" name="relation" class="form-control" placeholder="Relation between guardian and student" id="gr" />
                                                                                                    </div><br />

                                                                                                    <div class="teacher_name_pos">
                                                                                                        <input type="text" name="contact" class="form-control" placeholder="Contact number of guardian"  id="gc"/>
                                                                                                    </div><br />

                                                                                                    <div class="teacher_name_pos">
                                                                                                        <input type="text" name="gemail" class="form-control" placeholder="Email" id="ge" />
                                                                                                    </div><br />



                                                                                                    <div class="teacher_btn_pos">
                                                                                                        <input type="submit" name="btn_sub" href="#" class="btn btn-primary btn-large" value="Register" />&nbsp;&nbsp;&nbsp;
                                                                                                        <input type="reset" class="btn btn-primary btn-large" value="Cancel" />
                                                                                                    </div>


                                                                                                    <span>${param.msg}</span>




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