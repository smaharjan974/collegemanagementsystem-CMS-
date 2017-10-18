/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.impl;

import com.spring.dao.TeacherDao;
import com.spring.entity.Assignment;
import com.spring.entity.Attendance;
import com.spring.entity.Marks;
import com.spring.entity.Semester;
import com.spring.entity.Studentdb;
import com.spring.entity.Teacherdb; 
import com.spring.entity.Teachersubject;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SANJAY
 */
@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao{
   
    @Autowired
    SessionFactory sessionFactory;
    
    
    @Transactional
    public Teacherdb checklogin(String teacherid, String tpassword){
        Teacherdb teacher = null;
        try {
            
            teacher = (Teacherdb) sessionFactory.getCurrentSession().createQuery("From Teacherdb where teacherid=:x and tpassword=:y")
                    .setParameter("x", teacherid)
                    .setParameter("y", tpassword)
                    .uniqueResult();
            
        } catch (Exception e) {
        }
        return teacher;
    }
    
    @Transactional
   public List<String> view(String teacherid){ 
       
       List<String> list = (List<String>) sessionFactory.getCurrentSession().createQuery("SELECT subjectcode FROM Teachersubject where teacherid=:x")
               .setParameter("x", teacherid).list();
        System.out.println("list : " +list);       
       return list;
   }
   
   @Transactional
   public void insertassignment(Assignment a){
        sessionFactory.getCurrentSession().save(a);
   }
   
   @Transactional
   public List<Assignment> viewAssignment(){
       List<Assignment> list = sessionFactory.getCurrentSession().createQuery("From Assignment").list();
       return list;
   }
   
   @Transactional
   public void deleteassignment(int id){
       sessionFactory.getCurrentSession().delete(new Assignment(id));
   }
   
   @Transactional
   public List<Teachersubject> viewteacher(String teacherid){
       List<Teachersubject> list = sessionFactory.getCurrentSession().createQuery("From Teachersubject where teacherid=:x")
               .setParameter("x", teacherid).list();
       return list;
   }
   
 
   @Transactional
   public List<Studentdb> viewstudent(String facultyid,int batchid){
       List<Studentdb> list = sessionFactory.getCurrentSession().createQuery("From Studentdb where facultyid=:x and batchid=:y")
               .setParameter("x", facultyid).setParameter("y", batchid).list();
       return list;
   }
   
   @Transactional
   public int viewsemeterid(String facultyid,String subjectcode){
             List<Semester> list =sessionFactory.getCurrentSession().createQuery("from Semester where facultyid=:x and subjectcode=:y").setParameter("x", facultyid).setParameter("y", subjectcode).list();
       return list.get(0).getSemesterid();
   }
   
   @Transactional
   public void savemarks(Marks m){
       sessionFactory.getCurrentSession().save(m);
   }
   
   @Transactional
  public String viewmarks(String subjectcode,String roll){ 
     
      String roll1 = (String) sessionFactory.getCurrentSession().createQuery("Select roll From Marks where subjectcode=:x and roll=:y").setParameter("x", subjectcode)
              .setParameter("y", roll).uniqueResult();
     return roll1;
     }
  
     @Transactional
     public List<String> selectstudent(String subjectcode){
         List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT roll From Marks where subjectcode=:x").setParameter("x", subjectcode).list();
         return list;
     }
     
     @Transactional
     public Integer selectbatchid(String roll){
         Integer batchid = (Integer) sessionFactory.getCurrentSession().createQuery("Select batchid From Studentdb where roll=:x").setParameter("x", roll).uniqueResult();
         return batchid;
     }
     
     @Transactional
     public String selectfacultyid(String roll){
         String facultyid = (String )sessionFactory.getCurrentSession().createQuery("Select facultyid From Studentdb where roll=:x")
                 .setParameter("x", roll).uniqueResult();
         return facultyid;
     }    
     
     @Transactional
     public Marks viewm(String subjectcode,String roll){
         Marks m = (Marks)sessionFactory.getCurrentSession().createQuery("From Marks where subjectcode=:x and roll=:y")
                 .setParameter("y", roll).setParameter("x", subjectcode).uniqueResult();
         System.out.println("listttt====="+m);
         return m;
     }
     
     @Transactional
     public Marks getById(int id){
         Marks m = (Marks) sessionFactory.getCurrentSession().createQuery("From Marks where id=:x").setParameter("x", id).uniqueResult();
         return m;
     }
     
     @Transactional
     public void updatemarks(Marks m){
         sessionFactory.getCurrentSession().update(m);
     }
     
     @Transactional
     public void insertattendance(Attendance a){
         sessionFactory.getCurrentSession().save(a);
     }
     
     @Transactional
     public int getsemesterid(int batchid, String facultyid){
         int semid = (Integer)sessionFactory.getCurrentSession().createQuery("Select semesterid from Batchsemster where batchid=:x and facultyid=:y ")
                 .setParameter("x", batchid).setParameter("y", facultyid).uniqueResult();
         return semid;
     }
     
     @Transactional
     public List<Studentdb> getstudent(String roll){
         List<Studentdb> list = sessionFactory.getCurrentSession().createQuery("From Studentdb where roll=:x").setParameter("x", roll).list();
         return list;
     }
     
     @Transactional
     public List<String> getdate(String subjectcode,int semesterid,int batchid){
         List<String> date=sessionFactory.getCurrentSession().createQuery("Select Distinct date From Attendance where subjectcode=:x and semesterid=:y and batchid=:z")
                 .setParameter("x", subjectcode).setParameter("y", semesterid).setParameter("z", batchid).list();
         return date;
     }
     
     @Transactional
     public Studentdb getstd(String roll){
         Studentdb s=(Studentdb) sessionFactory.getCurrentSession().createQuery("From Studentdb where roll=:x")
                 .setParameter("x", roll).uniqueResult();
         return s;
     }
     
     @Transactional
     public int getbatch(String roll){
         int batchid=(Integer)sessionFactory.getCurrentSession().createQuery("Select batchid From Studentdb where roll=:x")
                 .setParameter("x", roll).uniqueResult();
         return batchid;
     }
     
     @Transactional
     public Attendance getattend(String subjectcode,String roll,String date){
         Attendance atlist = (Attendance)sessionFactory.getCurrentSession().createQuery("From Attendance where subjectcode=:x and roll=:y and date=:z")
                 .setParameter("x", subjectcode).setParameter("y", roll).setParameter("z", date).uniqueResult();
         return atlist;
     }
     
}
