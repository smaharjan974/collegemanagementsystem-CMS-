/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.impl;

import com.spring.dao.AdminDao;
import com.spring.entity.Admindb;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author SANJAY
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
    
    

    @Autowired
    SessionFactory sessionFactory;
    
    @Transactional
    public Admindb checklogin(String adminusername, String adminpassword) {
      
       
       Admindb admindb = null;
        try {
           admindb = (Admindb) sessionFactory.getCurrentSession().createQuery("from Admindb where adminusername=:x and adminpassword=:y")
                   .setParameter("x", adminusername)
                   .setParameter("y", adminpassword)
                   .uniqueResult();
        } catch (Exception e) {
        }
        return admindb;
       
       
    }

  @Transactional 
    public boolean insertstudent(Studentdb student){
        boolean check = false;
        try {
            sessionFactory.getCurrentSession().save(student);
         
        } catch (Exception e) {
        }
        if(sessionFactory.getCurrentSession().save(student)!=null){
           
            check = true;
        
        }
        return check;
    }
    
    @Transactional
    public List<Studentdb> viewstudent(){
        List<Studentdb> studentlist = sessionFactory.getCurrentSession().createQuery("From Studentdb").list();
        return studentlist;
    }
    
    @Transactional
    public void deletestudent(String roll){
        sessionFactory.getCurrentSession().delete(new Studentdb(roll));
    }

    @Transactional
    public boolean insertfaculty(Faculty faculty) {
    boolean check = false;
        try {
            sessionFactory.getCurrentSession().save(faculty);
        } catch (Exception e) {
        }
        if(sessionFactory.getCurrentSession().save(faculty)!=null){
            check = true;
        }
        return check;
    }

    @Transactional
    public List<Faculty> viewfaculty (){
        List<Faculty> list = sessionFactory.getCurrentSession().createQuery("FROM Faculty").list();
        
        return list;
    }
    
    @Transactional
    public void deletefaculty(String facultyid){
        sessionFactory.getCurrentSession().delete(new Faculty(facultyid));
    }

    @Transactional
     public boolean insertsubject(Subject subject){
         boolean check = false;
         try {
            sessionFactory.getCurrentSession().save(subject);
            
        } catch (Exception e) {
        }
         if(sessionFactory.getCurrentSession().save(subject)!=null){
             return check = true;
         }
         return check;
     }
     
     
     @Transactional
    public List<Subject> viewsubject (){
        List<Subject> list = sessionFactory.getCurrentSession().createQuery("FROM Subject").list();
        
        return list;
    }
    
    @Transactional
    public void deletesubject(String subjectcode){
        sessionFactory.getCurrentSession().delete(new Subject(subjectcode));
    }
    
    @Transactional
    public boolean insertbatch(Batch batch){
        boolean check = false;
        try {
            sessionFactory.getCurrentSession().save(batch);
        } catch (Exception e) {
    
        }
        if(sessionFactory.getCurrentSession().save(batch)!=null){
            check = true;
        }
        return check;
    }
    
    @Transactional
     public List<Batch> viewbatch(){
         List<Batch> list = sessionFactory.getCurrentSession().createQuery("FROM Batch").list();
        
        return list;
     }
     
     @Transactional
     public Batch getBatchById(int batchid){
         Batch batch = null;
         try {
             batch = (Batch) sessionFactory.getCurrentSession().get(Batch.class,batchid);
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return batch;
     }
     
     @Transactional
     public void deletebatch(int batchid){
//         Batch batch = (Batch)session.get(Batch.class, batchid);
      //Batch batch = (Batch) sessionFactory.getCurrentSession().load(Batch.class,batchid);
//        if(batch!=null){
             sessionFactory.getCurrentSession().delete(new Batch(batchid));
        // }
                 
     }
     
     
//     @Transactional
//     public void deletebatch(int batchid){
//        Batch batch = (Batch) session.get(Batch.class,batchid);
//        if(batch!=null){
//             sessionFactory.getCurrentSession().delete(batchid);
//         }
//
//     }
     
     @Transactional
     public void updatebatch(Batch batch){
         sessionFactory.getCurrentSession().update(batch);
     }
    
    @Transactional
     public boolean insertsemester(Semester semester){
          boolean check = false;
        try {
            sessionFactory.getCurrentSession().save(semester);
        } catch (Exception e) {
        }
        if(sessionFactory.getCurrentSession().save(semester)!=null){
            check = true;
        }
        return check;
     }
     
     @Transactional
     public List<Semester> viewsemester (){
         List<Semester> semesterlist = sessionFactory.getCurrentSession().createQuery("From Semester").list();
         return semesterlist;
     }
     
     @Transactional
     public void deletesemester(int id){
         sessionFactory.getCurrentSession().delete(new Semester(id));
     }

     
     @Transactional
     public List<Semestername> viewsemestername(){
         List<Semestername> semesternamelist = sessionFactory.getCurrentSession().createQuery("From Semestername").list();
         return semesternamelist;
     }
      
     @Transactional
    public boolean insertteacher(Teacherdb teacher){
        boolean check = false;
         try {
             sessionFactory.getCurrentSession().save(teacher);
             
         } catch (Exception e) {
         }
         if(sessionFactory.getCurrentSession().save(teacher)!=null){
             check = true;
         }
        return check;
    }
    
    @Transactional
    public List<Teacherdb> viewteacher(){
        List<Teacherdb> teacherdb = sessionFactory.getCurrentSession().createQuery("From Teacherdb").list();
        return teacherdb;
    }
    
    @Transactional
    public boolean insertsubjectteacher(Teachersubject subteacher){
        boolean check = false;
        try {
            sessionFactory.getCurrentSession().save(subteacher);
        } catch (Exception e) {
        }
        if(sessionFactory.getCurrentSession().save(subteacher)!=null){
            check = true;
        }
        
        return check;
        
    }
    
    @Transactional
    public void deleteteacher(String teacherid){
        sessionFactory.getCurrentSession().delete(new Teacherdb(teacherid));
    }
    
    @Transactional
    public List<Teachersubject> viewteacherteaches(){
        List<Teachersubject> teachersublist = sessionFactory.getCurrentSession().createQuery("From Teachersubject").list();
        return teachersublist;
    }
    
    @Transactional
    public void deletesubjecttaught(int id){
        sessionFactory.getCurrentSession().delete(new Teachersubject(id));
    }
    
    @Transactional
     public void insertevent(Event event){
        
            try {
                sessionFactory.getCurrentSession().save(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
     }
     
     @Transactional
     public List<Event> getevent(){
         List<Event> list = sessionFactory.getCurrentSession().createQuery("From Event").list();
         return list;
     }
     
     @Transactional
     public void deleteevent(int id){
         sessionFactory.getCurrentSession().delete(new Event(id));
     }
    
     @Transactional
    public boolean insertbatchsem(Batchsemster batchsem){
         boolean check = false;
         try {
            sessionFactory.getCurrentSession().save(batchsem);
        } catch (Exception e) {
        }
         if(sessionFactory.getCurrentSession().save(batchsem)!=null){
             check=true;
         }
         return check;
     }
    
    
    @Transactional
     public Batchsemster getBatchsemById(int id){
         Batchsemster batchsem = null;
         try {
             batchsem = (Batchsemster) sessionFactory.getCurrentSession().createQuery(" From Batchsemster where id=:x")
                 .setInteger("id", id)
                 .uniqueResult();
         } catch (Exception e) {
         }
         
         return batchsem;
     }     
    
     
     @Transactional
     public void updatebatchsem(Batchsemster batchsem){
       sessionFactory.getCurrentSession().update(batchsem);
     }
     
     @Transactional
     public void deletebatchsem(int id){
         sessionFactory.getCurrentSession().delete(new Batchsemster(id));
     }

             
    @Transactional
    public List<Batchsemster> viewbatchsem(){
        List<Batchsemster> batchsemlist = sessionFactory.getCurrentSession().createQuery("from Batchsemster").list();
        return batchsemlist; 
    }
    
    @Transactional
    public List<Faculty> getfacultyid(String facultyid){
        List<Faculty> list = sessionFactory.getCurrentSession().createQuery(" From Faculty where facultyid=:x")
                .setParameter("x", facultyid)
                .list();
        return list;
                
    }
   
    @Transactional
    public String getsubjectname(String subjectcode){
        String subjectname=(String) sessionFactory.getCurrentSession().createQuery("Select subjectname From Subject where subjectcode=:X")
                .setParameter("x", subjectcode).uniqueResult();
        return subjectname;
    }
    
    @Transactional
    public List<String> getsubjectcode(int semesterid,String facultyid){
        List<String> sublist = sessionFactory.getCurrentSession().createQuery("Select subjectcode From Semester where semesterid=:x and facultyid=:y")
                .setParameter("x", semesterid).setParameter("y", facultyid).list();
        return sublist;
    }
    
    @Transactional
    public Subject getsubjectlist(String subjectcode){
        Subject sublist = (Subject) sessionFactory.getCurrentSession().createQuery("From Subject where subjectcode=:x").setParameter("x", subjectcode).uniqueResult();
        return sublist;
    }
    
    @Transactional
    public List<Studentdb> getstudent(int batchid,String facultyid){
        List<Studentdb> stlist = sessionFactory.getCurrentSession().createQuery("From Studentdb where batchid=:x and facultyid=:y")
                .setParameter("x", batchid).setParameter("y", facultyid).list();
        return stlist;
    }
    
    @Transactional
    public Marks getinternalmarks(String roll,int semesterid,String subjectcode){
        Marks mlist = (Marks) sessionFactory.getCurrentSession().createQuery("From Marks where roll=:x and semesterid=:y and subjectcode=:z")
                .setParameter("x", roll).setParameter("y", semesterid).setParameter("z", subjectcode).uniqueResult();
        return mlist;
    }
    
    @Transactional
    public boolean getAttendance(String roll,String subjectcode, String date){
        boolean check = (Boolean)sessionFactory.getCurrentSession().createQuery("Select attendance From Attendance where roll=:x and subjectcode=:y and date=:z")
                    .setParameter("x", roll).setParameter("y", subjectcode).setParameter("z", date).uniqueResult();
        System.out.println("============"+check);
        return check;
    }
   
    @Transactional
    public List<String> getdate(String subjectcode, int batchid,int semesterid){
        List<String> date = sessionFactory.getCurrentSession().createQuery("Select Distinct date From Attendance where subjectcode=:x and batchid=:y and semesterid=:z")
                .setParameter("x", subjectcode).setParameter("y", batchid).setParameter("z", semesterid).list();
        return date;
    }


    }
     
   

    

