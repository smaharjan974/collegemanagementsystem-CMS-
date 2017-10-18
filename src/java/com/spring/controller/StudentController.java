/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.dao.AdminDao;
import com.spring.dao.StudentDao;
import com.spring.emailapi.EmailSending;
import com.spring.entity.Assignment;
import com.spring.entity.AttendanceStd;
import com.spring.entity.Marks;
import com.spring.entity.MarksSubject;
import com.spring.entity.Semester;
import com.spring.entity.StdAssign;
import com.spring.entity.StudentSubMark;
import com.spring.entity.Studentdb;
import com.spring.entity.Subject;
import com.spring.entity.SubjectTotal;
import com.spring.entity.Teacherdb;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SANJAY
 */
@Controller
public class StudentController {

    @Autowired
    StudentDao stdDao;

    @Autowired
    AdminDao adminDao;
    
    @Autowired
    HttpSession session;

    @RequestMapping("/studentlogin")
    public String studentlogin() {
        return "studentlogin";
    }

    @RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
    public String checkstudentlogin(@RequestParam("roll") String roll, @RequestParam("password") String password,Model model) {
        boolean check = stdDao.checkstudentlogin(roll, password);
        Studentdb s = stdDao.getstudent(roll);
        
        session.setAttribute("firstname", s.getSfirstname());
        session.setAttribute("lastname", s.getSlastname());
        session.setAttribute("roll", s.getRoll());
        if (check) {
            return "redirect:/student";
        } else {
            return "redirect:/studentlogin";
        }
    }

    @RequestMapping(value = "/student")
    public String studenthomepage(Model model) {
        model.addAttribute("roll", session.getAttribute("roll"));
        Studentdb s = stdDao.getstudent((String) session.getAttribute("roll"));
        model.addAttribute("s", s);
        int semid=stdDao.getsmesterid(s.getFacultyid(), s.getBatchid());
        model.addAttribute("semid", semid);
        return "studenthomepage";
    }

    @RequestMapping(value = "/marksheet", method = RequestMethod.GET)
    public String choosemarksheet() {
        return "choosemarksheet";
    }

    @RequestMapping(value = "/marksheet", method = RequestMethod.POST)
    public String marksheet(Model model, @RequestParam("semesterid") int semesterid, @RequestParam("choosemarksheet") String choosemarksheet) {
        String roll = (String) session.getAttribute("roll");
        Studentdb s = stdDao.getstudent(roll);
        List<Semester> semlist = stdDao.getsubject(s.getFacultyid(), semesterid);
        List<Subject> subject = new ArrayList<Subject>();
        for (int i = 0; i < semlist.size(); i++) {
            Subject sub = stdDao.getsubjects(semlist.get(i).getSubjectcode());
            subject.add(sub);
        }
        List<MarksSubject> marks = new ArrayList<MarksSubject>();

        for (int j = 0; j < subject.size(); j++) {
            List<Marks> m = new ArrayList<Marks>();
            MarksSubject marksub = new MarksSubject();
            marksub.setSubject(subject.get(j));
            Marks mark = stdDao.getmarks(s.getRoll(), subject.get(j).getSubjectcode(), semesterid);
            m.add(mark);
            marksub.setMarks(m);
            marks.add(marksub);

        }
        System.out.println("+++++++++" + marks);
        model.addAttribute("marksub", marks);
        model.addAttribute("semid", semesterid);
        model.addAttribute("s", s);
        if ("internal".equals(choosemarksheet)) {

            return "internalmarksheet";
        } else {
            return "boardmarksheet";
        }
    }
    
    @RequestMapping("/assignment")
    public String assignment(Model model){
        String roll = session.getAttribute("roll").toString();
        Studentdb s = stdDao.getstudent(roll);
        int batchid=s.getBatchid();
        int semid = stdDao.getsmesterid(s.getFacultyid(), batchid);
        System.out.println("====");
        List<String> subject = stdDao.getSubject(semid, s.getFacultyid());
        System.out.println("============aa");
        List<String> teacherid = new ArrayList<String>();
        for(int i=0;i<subject.size();i++){
           String tid = stdDao.getteacherid(subject.get(i), s.getFacultyid(), batchid);
            teacherid.add(tid);
        }
        
        try {
            List<StdAssign> stassign = new ArrayList<StdAssign>();
            for(int i=0;i<teacherid.size();i++){
                StdAssign stdassign = new StdAssign();
                Teacherdb t = stdDao.getteacher(teacherid.get(i));
                System.out.println("=========");
                List<String> subcode = stdDao.getsubjectcode(t.getTeacherid(), s.getFacultyid(),s.getBatchid());
                for(int j=0;j<subcode.size();j++){
                    Subject sub=stdDao.getsub(subcode.get(j));
                    List<Assignment> assign = stdDao.getassignment(teacherid.get(i), subcode.get(j));
                    stdassign.setTeacher(t);
                    stdassign.setSubject(sub);
                    stdassign.setDetails(assign);
                    stassign.add(stdassign);
                }
                
            }
             model.addAttribute("assign", stassign);
        } catch (Exception e) {
        }
       
        return "assignment";
    }
    
    @RequestMapping("/attendances")
    public String getattendance(Model model){
        String roll = (String)session.getAttribute("roll");
        Studentdb s = stdDao.getstudent(roll);
         int semid = stdDao.getsmesterid(s.getFacultyid(), s.getBatchid());
         List<String> subject = stdDao.getSubject(semid, s.getFacultyid());
         
        List<AttendanceStd> subt = new ArrayList<AttendanceStd>();
        for(int i=0;i<subject.size();i++){
            AttendanceStd attstd = new AttendanceStd();
            Subject su = stdDao.getsub(subject.get(i));
            attstd.setSubject(su);
            List<String> date= adminDao.getdate(su.getSubjectcode(),s.getBatchid(),semid);
            int totaldays=date.size();
            int count = 0;
            for(int j=0;j<date.size();j++){
                 boolean check = adminDao.getAttendance(s.getRoll(), subject.get(i), date.get(j));
                if(check){
                    count = count + 1;
                }
                attstd.setTotaldays(totaldays);
                attstd.setPresent(count);
                
            }
            subt.add(attstd);
        }
        model.addAttribute("subt", subt);
        
         
        return "stdattendance";
    }
    
    @RequestMapping("/changepassword")
    public String changestdpassword(){
        return "stdchangepassword";
    }
    
    @RequestMapping(value="/changepassword",method=RequestMethod.POST)
    public String _changestdpassword(@RequestParam("oldpass") String oldpass,@RequestParam("newpass") String newpass,@RequestParam("confirmpass") String confirmpass,Model model){
        String roll =(String) session.getAttribute("roll");
        Studentdb s = stdDao.getstudent(roll);
        try {
            if(s.getPassword().equals(oldpass)){
            if(newpass.equals(confirmpass)){
                Studentdb st = new Studentdb(roll, s.getSfirstname(), s.getSlastname(), s.getSgender(), s.getsDOB(), s.getFacultyid(),
                        s.getBatchid(), s.getSaddress(), s.getScontact(), s.getBloodgroup(), s.getSemail(),newpass,
                        s.getGfirstname(), s.getGlastname(), s.getRelation(), s.getContact(), s.getGemail());
                stdDao.updatepass(st);
                model.addAttribute("msg", "Password update successfully!!!");
            }else{
                model.addAttribute("msg", "password did not match!!!");
            }
        }else{
                 model.addAttribute("msg", "Current password did not Match!!!");
            }
        } catch (Exception e) {
           
        }
        return "redirect:/student";
    }
    
    @RequestMapping("/student/forgetpassword")
    public String forgetpassword(){
        String roll = (String)session.getAttribute("roll");
        Studentdb s = stdDao.getstudent(roll);
        
        return "forgotpassword";
        
    }
    
    @RequestMapping(value="/student/forgetpassword", method=RequestMethod.POST)
    public String _forgetpassword(Model model, @RequestParam("roll") String roll, @RequestParam("email") String email) throws EmailException{
        Studentdb s = stdDao.getstudent(roll);
        String password = s.getPassword();
        if(s.getSemail().equals(email)){
            EmailSending emailsent = new EmailSending(email, roll, password);
            model.addAttribute("msg", "Email was sent to your EmailID");
        }else{
            model.addAttribute("msg", "Wrong username and email");
        }
        return "redirect:/studentlogin";
        
    }

}
