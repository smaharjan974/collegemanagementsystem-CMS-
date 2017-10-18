/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.impl;

import com.spring.dao.StudentDao;
import com.spring.entity.Assignment;
import com.spring.entity.Marks;
import com.spring.entity.Semester;
import com.spring.entity.Studentdb;
import com.spring.entity.Subject;
import com.spring.entity.Teacherdb;
import com.spring.entity.Teachersubject;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SANJAY
 */
@Repository("stdDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean checkstudentlogin(String roll, String password) {
        boolean check = false;

        Studentdb student = null;
        try {
            student = (Studentdb) sessionFactory.getCurrentSession().createQuery("From Studentdb where roll=:x and password=:y")
                    .setParameter("x", roll)
                    .setParameter("y", password)
                    .uniqueResult();
        } catch (Exception e) {
        }
        if (student != null) {
            check = true;
        }
        return check;
    }

    @Transactional
    public Studentdb getstudent(String roll) {
        Studentdb s = (Studentdb) sessionFactory.getCurrentSession().createQuery("From Studentdb where roll=:x").setParameter("x", roll).uniqueResult();
        return s;
    }

    @Transactional
    public List<Semester> getsubject(String facultyid, int semesterid) {
        List<Semester> sm = sessionFactory.getCurrentSession().createQuery("From Semester where facultyid=:x and semesterid=:y")
                .setParameter("x", facultyid).setParameter("y", semesterid).list();
        return sm;
    }

    @Transactional
    public Subject getsubjects(String subjectcode) {
        Subject s = (Subject) sessionFactory.getCurrentSession().createQuery("From Subject where subjectcode=:x").setParameter("x", subjectcode).uniqueResult();
        return s;
    }

    @Transactional
    public Marks getmarks(String roll, String subjectcode, int semesterid) {
        Marks m = (Marks) sessionFactory.getCurrentSession().createQuery("From Marks where roll=:x and subjectcode=:y and semesterid=:z")
                .setParameter("x", roll).setParameter("y", subjectcode).setParameter("z", semesterid).uniqueResult();
        return m;
    }

    @Transactional
    public int getsmesterid(String facultyid, int batchid) {
        int semesterid = (Integer) sessionFactory.getCurrentSession().createQuery("Select semesterid From Batchsemster where facultyid=:x and batchid=:y")
                .setParameter("x", facultyid).setParameter("y", batchid).uniqueResult();
        return semesterid;
    }

    @Transactional
    public List<String> getSubject(int semesterid, String facultyid) {
        List<String> list = sessionFactory.getCurrentSession().createQuery("Select subjectcode From Semester where semesterid =:x and facultyid=:y")
                .setParameter("x", semesterid).setParameter("y", facultyid).list();
        return list;

    }
    
    @Transactional
    public String getteacherid(String subjectcode, String facultyid, int batchid){
        Teachersubject ts=null;
        System.out.println("========"+subjectcode+"=="+facultyid+"======"+batchid);
        try{
        //ts = (Teachersubject)sessionFactory.getCurrentSession().createQuery("FROM Teachersubject WHERE subjectcode=:x AND facultyid=:y	AND batchid=:z").setParameter("x",subjectcode).setParameter("y", facultyid).setParameter("z", batchid).uniqueResult();
        ts = (Teachersubject)sessionFactory.getCurrentSession().createQuery("FROM Teachersubject").list().get(0);
        System.out.println("====="+ts.getTeacherid());
        }catch(Exception ex){ex.getMessage();}
        return ts.getTeacherid();
                
    }
    
    @Transactional
    public Teacherdb getteacher(String teacherid){
        Teacherdb t = (Teacherdb) sessionFactory.getCurrentSession().createQuery("From Teacherdb where teacherid=:x")
                .setParameter("x", teacherid).uniqueResult();
        return t;
    }
    
    @Transactional
    public List<String> getsubjectcode(String teacherid,String facultyid,int batchid){
        List<String> subcode = sessionFactory.getCurrentSession().createQuery("Select subjectcode From Teachersubject where"
                + "teacherid=:x and facultyid=:y and batchid=:z")
                .setParameter("x", teacherid).setParameter("y", facultyid).setParameter("z", batchid).list();
        return subcode;
    }
    
    @Transactional
    public Subject getsub(String subjectcode){
        Subject s = (Subject)sessionFactory.getCurrentSession().createQuery("From Subject where subjectcode=:x")
                .setParameter("x", subjectcode).uniqueResult();
        return s;
    }
    
    @Transactional
    public  List<Assignment> getassignment(String teacherid,String subjectcode){
        List<Assignment> assign = sessionFactory.getCurrentSession().createQuery("From Assignment where teacherid=:x and subjectcode=:y")
                .setParameter("x", teacherid).setParameter("y", subjectcode).list();
        return assign;
    }
    
    @Transactional
    public void updatepass(Studentdb s){
        sessionFactory.getCurrentSession().update(s);
    }
}
