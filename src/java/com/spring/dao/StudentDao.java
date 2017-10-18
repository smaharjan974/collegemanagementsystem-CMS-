/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;

import com.spring.entity.Assignment;
import com.spring.entity.Marks;
import com.spring.entity.Semester;
import com.spring.entity.Studentdb;
import com.spring.entity.Subject;
import com.spring.entity.Teacherdb;
import java.util.List;

/**
 *
 * @author SANJAY
 */
public interface StudentDao {
    boolean checkstudentlogin(String roll, String password);
    Studentdb getstudent(String roll);
    List<Semester> getsubject(String facultyid,int semesterid);
    Subject getsubjects(String subjectcode);
    Marks getmarks(String roll,String subjectcode, int smesterid);
    int getsmesterid(String facultyid,int batchid);
    List<String> getSubject(int semesterid, String facultyid);
    String getteacherid(String subjectcode, String facultyid, int batchid);
    Teacherdb getteacher(String teacherid);
    List<String> getsubjectcode(String teacherid,String facultyid,int batchid);
    List<Assignment> getassignment(String teacherid,String subjectcode);
    Subject getsub(String subjectcode);
    void updatepass(Studentdb s);
}
