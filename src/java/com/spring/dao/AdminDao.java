/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;

import com.spring.entity.Admindb;
import com.spring.entity.Attendance;
import com.spring.entity.Batch;
import com.spring.entity.Batchsemster;
import com.spring.entity.Event;
import com.spring.entity.Faculty;
import com.spring.entity.Marks;

import com.spring.entity.Semester;
import com.spring.entity.Semestername;
import com.spring.entity.Studentdb;
import com.spring.entity.Subject;
import com.spring.entity.Teacherdb;
import com.spring.entity.Teachersubject;

import java.util.List;


/**
 *
 * @author SANJAY
 */
public interface AdminDao {
    public Admindb checklogin(String adminusername, String adminpassword);
    public boolean insertfaculty(Faculty faculty);
    public List<Faculty> viewfaculty ();
    public void deletefaculty(String facultyid);
    public boolean insertsubject(Subject subjecct);
    public List<Subject> viewsubject ();
    public void deletesubject(String subjectcode);
    public boolean insertbatch(Batch batch);
    public Batch getBatchById(int batchid);
    public void deletebatch(int batchid);
    public List<Batch> viewbatch();
    void updatebatch(Batch batch);
    public boolean insertsemester(Semester semester);
    public List<Semester> viewsemester ();
    public void deletesemester(int id);
    public List<Semestername> viewsemestername();
    public boolean insertteacher(Teacherdb teacher);
    public List<Teacherdb> viewteacher();
    public boolean insertsubjectteacher(Teachersubject subteacher);
    public List<Teachersubject> viewteacherteaches();
    public void deletesubjecttaught(int id);
    public void deleteteacher(String teacherid);
    public boolean insertstudent(Studentdb student);
    public List<Studentdb> viewstudent();
    public void deletestudent(String roll);
    public void insertevent(Event event);
    List<Event> getevent();
    void deleteevent(int id);
    public boolean insertbatchsem(Batchsemster batchsem);
    public void updatebatchsem(Batchsemster batchsem);
    public void deletebatchsem(int id);
    public Batchsemster getBatchsemById(int id);
    public List<Batchsemster> viewbatchsem();  
    List<Faculty> getfacultyid(String facultyid);
    String getsubjectname(String subjectcode);
    List<String> getsubjectcode(int semesterid,String facultyid);
    Subject getsubjectlist(String subjectcode);
    List<Studentdb> getstudent(int batchid,String facultyid);
    Marks getinternalmarks(String roll,int semesterid,String subjectcode);
   
    boolean getAttendance(String roll,String subjectcode, String date);
    List<String> getdate(String subjectcode, int batchid,int semesterid);

}
