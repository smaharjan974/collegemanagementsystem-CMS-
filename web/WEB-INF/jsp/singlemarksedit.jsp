<%-- 
    Document   : singlemarksedit
    Created on : Jul 7, 2017, 11:20:27 PM
    Author     : SANJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.servletContext.contextPath}/updatemarks/${marks.id}" >    
			<div class="container">
                            
                            
				<p style="text-align:center;">Here, you'll add new batch (year) into database.</p>
			</div>
<div class="teacher_bday_box" style="margin-left: 0px;">
					<div class="select_style">
    					
                                        <input type="text" name="id"  value="${marks.id}" hidden/>
                                           <br/><br/>

                                        <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="roll" placeholder="Roll" value="${marks.roll}" hidden/>
                                    </div><br><BR/>
                                    
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="semesterid" placeholder="Semesterid" value="${marks.semesterid}" hidden/>
                                    </div><br><BR/>
                                    
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="subjectcode" placeholder="Subject code" value="${marks.subjectcode}" hidden/>
                                    </div><br><BR/>
                                    
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="internalpratical" placeholder="Internal pratical" value="${marks.internalpratical}" hidden/>
                                    </div><br><BR/>
                                    
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="internaltheory" placeholder="Internal Theory" value="${marks.internaltheory}" hidden/>
                                    </div><br><BR/>
                                    
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="finalpratical" placeholder="Final Pratical" value="${marks.finalpratical}"/>
                                    </div><br><BR/>
                                    <div class="teacher_bday_box" style="margin-left: 0px;">    
                                        <br/>Roll
                                        <input type="text" name="finaltheory" placeholder="Final Theory" value="${marks.finaltheory}"/>
                                    </div><br><BR/>
                                    
                                        
                                        
                                        <input type="submit" value="update" /> 
                                        <input type="submit" value="cancel"/>
                                        </div><br/><br/>
                                        
                                    


           </form>
    </body>
</html>
