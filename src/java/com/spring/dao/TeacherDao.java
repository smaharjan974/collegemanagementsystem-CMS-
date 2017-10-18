/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;


import com.spring.entity.Assignment;
import com.spring.entity.Attendance;
import com.spring.entity.Marks;
import com.spring.entity.Studentdb;
import com.spring.entity.Teacherdb;
import com.spring.entity.Teachersubject;
import java.util.List;

/**
 *
 * @author SANJAY
 */
public interface TeacherDao {
    Teacherdb checklogin(String teacherid, String tpassword);
    List<String> view(String teacherid);
    void insertassignment(Assignment a);
    List<Assignment> viewAssignment();
    void deleteassignment(int id);
    List<Teachersubject> viewteacher(String teacherid);
    List<Studentdb> viewstudent(String facultyid,int batchid);
    int viewsemeterid(String facultyid,String subjectcode);
    void savemarks(Marks m);
    String viewmarks(String subjectcode,String roll);
   List<String> selectstudent(String subjectcode);
   Integer selectbatchid(String roll);
   String selectfacultyid(String roll);
   Marks viewm(String subjectcode,String roll);
   Marks getById(int id);
   void updatemarks(Marks m);
   void insertattendance(Attendance a);
   int getsemesterid(int batchid, String facultyid);
   List<Studentdb> getstudent(String roll);
   
   List<String> getdate(String subjectcode,int semesterid,int batchid);
   Studentdb getstd(String roll);
   int getbatch(String roll);
   Attendance getattend(String subjectcode,String roll,String date);
}
