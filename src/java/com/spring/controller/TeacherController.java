package com.spring.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.spring.dao.AdminDao;
import com.spring.dao.TeacherDao;
import com.spring.entity.Assignment;
import com.spring.entity.Attend;
import com.spring.entity.Attendance;
import com.spring.entity.Batch;
import com.spring.entity.Faculty;
import com.spring.entity.Marks;
import com.spring.entity.Semester;
import com.spring.entity.Studentdb;
import com.spring.entity.Teacherdb;
import com.spring.entity.Teachersubject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SANJAY
 */
@Controller
public class TeacherController {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    AdminDao adminDao;

    @RequestMapping("/teacherlogin")
    public String teacherlogin() {
        return "teacherlogin";
    }

    @RequestMapping("/teacher/logout")
    public String logout() {
        return "redirect:/";
    }

    @RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
    public String checkteacherlogin(@RequestParam("teacherid") String teacherid, @RequestParam("tpassword") String tpassword) {
        Teacherdb teacher = teacherDao.checklogin(teacherid, tpassword);
        if (teacher != null) {
            session.setAttribute("teacherid", teacherid);
            session.setAttribute("teachername", teacher.getTeacherid());
            session.setAttribute("teaccher", teacher);
            return "redirect:/teacherhomepage";
        } else {
            return "redirect:/teacherlogin";
        }
    }

    @RequestMapping("/teacherhomepage")
    public String teacherhomepage() {
        return "teacherhomepage";
    }

    @RequestMapping("/addassignment")
    public String addassignment(Model model) {
        String teacherid = (String) session.getAttribute("teachername");
        List<String> list = teacherDao.view(teacherid);
        model.addAttribute("list", list);
        return "assignmententry";
    }

    @RequestMapping(value = "/adddassignment", method = RequestMethod.POST)
    public String _addassignment(Model model) throws IOException {

        String path = request.getServletContext().getRealPath("") + "/resources/assignment";

        MultipartRequest mrequest = new MultipartRequest((HttpServletRequest) request, path, 30000000, new FileRenamePolicy() {
            @Override
            public File rename(File file) {
                String name = String.valueOf(new Date().getTime());
                String ext = FilenameUtils.getExtension(file.getName());
                return new File(file.getParentFile(), name + "." + ext);
            }
        });

        String filename = null;
        Enumeration files = mrequest.getFileNames();
        if (files.hasMoreElements()) {
            filename = mrequest.getFilesystemName(files.nextElement().toString());
        }

        String ext = FilenameUtils.getExtension(filename);
        if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("txt") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("doc")) {
            String subjectcode = mrequest.getParameter("subjectcode");
            String name = mrequest.getParameter("name");
            String deadline = mrequest.getParameter("deadline");
            String teacherid = (String) session.getAttribute("teacherid");
            String remarks = mrequest.getParameter("remarks");
            Assignment a = new Assignment(0, teacherid, subjectcode, name, filename, deadline, remarks);
            teacherDao.insertassignment(a);
            model.addAttribute("postmsg", "inserted successfully");
        } else {
            Files.delete(new File(path + "/" + filename).toPath());
            model.addAttribute("postmsg", "invalid format");
        }
        return "redirect:/addassignment";

    }

    @RequestMapping("/viewassignment")
    public String viewassignment(Model model) {
        List<Assignment> list = teacherDao.viewAssignment();
        model.addAttribute("list", list);
        return "viewassignment";
    }

    @RequestMapping("/deleteassignment/{id}")
    public String deleteassignment(@PathVariable("id") int id) {
        teacherDao.deleteassignment(id);
        return "redirect:/viewassignment";
    }

    @RequestMapping(value = "/addmarks", method = RequestMethod.GET)
    public String entrymarks(Model model) {
        String teacherid = (String) session.getAttribute("teacherid");
        List<Teachersubject> list = teacherDao.viewteacher(teacherid);
        model.addAttribute("tlist", list);
        return "marksentry";
    }

    @RequestMapping(value = "/entrymarks", method = RequestMethod.POST)
    public String marks(@RequestParam("subjectcode") String subjectcode, @RequestParam("facultyid") String facultyid, @RequestParam("batchid") String batchid, Model model) {
        int batchid1 = Integer.parseInt(batchid);

        int semid = teacherDao.viewsemeterid(facultyid, subjectcode);
        int sid = teacherDao.getsemesterid(batchid1, facultyid);
        if (sid == semid) {
            List<Studentdb> list = teacherDao.viewstudent(facultyid, batchid1);

            List<Studentdb> stlst = new ArrayList<Studentdb>();
            for (int i = 0; i < list.size(); i++) {

                String roll = teacherDao.viewmarks(subjectcode, list.get(i).getRoll());
                if (roll == null) {
                    stlst.add(list.get(i));
                }
            }
            model.addAttribute("stlist", stlst);
            model.addAttribute("sem", semid);
            model.addAttribute("subjectcode", subjectcode);
            return "marks";
        } else {
            model.addAttribute("msg", "Select Valid Data");
            return "redirect:/addmarks";
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savemarks(@RequestParam("subjectcode") String subjectcode, @RequestParam("semesterid") Integer semesterid, @RequestParam("roll") String[] roll, @RequestParam("internalpratical") Integer[] internalpratical,
            @RequestParam("internaltheory") Integer[] internaltheory, @RequestParam("finalpratical") Integer[] finalpratical, @RequestParam("finaltheory") Integer[] finaltheory) {

        System.out.println("=asdfasdf" + semesterid);

        for (int i = 0; i < roll.length; i++) {
            System.out.println(semesterid + "=====" + roll[i]);
            Marks m = new Marks(0, roll[i], semesterid, subjectcode, internalpratical[i], internaltheory[i], finalpratical[i], finaltheory[i]);
            teacherDao.savemarks(m);
        }
        return "redirect:/teacherhomepage";
    }

    @RequestMapping(value = "/marksview", method = RequestMethod.GET)
    public String viewmarks(Model model) {
        String teacherid = (String) session.getAttribute("teacherid");
        List<Teachersubject> tlist = teacherDao.viewteacher(teacherid);
        System.out.println("teacher" + tlist);
        model.addAttribute("tlist", tlist);
        return "marksview";
    }

    @RequestMapping(value = "/viewmarks", method = RequestMethod.POST)
    public String view(@RequestParam("subjectcode") String subjectcode, @RequestParam("facultyid") String facultyid,
            @RequestParam("batchid") String batchid, Model model) {
        session.setAttribute("subjectcode", subjectcode);
        String teacherid = (String) session.getAttribute("teacherid");
        int batchid1 = Integer.parseInt(batchid);
        List<String> stmlist = teacherDao.selectstudent(subjectcode);
        List<Marks> mlist = new ArrayList<Marks>();
        for (int i = 0; i < stmlist.size(); i++) {
            Integer sbatchid = teacherDao.selectbatchid(stmlist.get(i));
            String sfacultyid = teacherDao.selectfacultyid(stmlist.get(i));
            if (sbatchid.equals(batchid1) && sfacultyid.equals(facultyid)) {
                Marks m = teacherDao.viewm(subjectcode, stmlist.get(i));
                mlist.add(m);
            }
        }
        model.addAttribute("markslist", mlist);
        return "viewmarks";
    }
    
    @RequestMapping(value="/editmarks")
    public String editmarks(@RequestParam("roll") String[] roll,@RequestParam("semesterid") Integer semesterid,Model model){
        
        model.addAttribute("semesterid", semesterid);
        System.out.println("===="+semesterid);
       String subjectcode1 = (String) session.getAttribute("subjectcode");
        List<Marks> mlist = new ArrayList<Marks>();
        for(int i=0;i<roll.length;i++){
            System.out.println("======================="+roll[i]);
            Marks m = teacherDao.viewm(subjectcode1, roll[i]);
            mlist.add(m);
        }
        model.addAttribute("marks", mlist);
        
        return "editmarks";
    }
    
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String updatemarks(@RequestParam(value="id") Integer[] id,@RequestParam("subjectcode") String subjectcode, @RequestParam("semesterid") Integer semesterid, @RequestParam("roll") String[] roll, @RequestParam("internalpratical") Integer[] internalpratical,
            @RequestParam("internaltheory") Integer[] internaltheory, @RequestParam("finalpratical") Integer[] finalpratical, @RequestParam("finaltheory") Integer[] finaltheory){
        
        for(int i = 0;i<roll.length;i++){
            Marks m = new Marks(id[i], roll[i], semesterid, subjectcode, internalpratical[i], internaltheory[i], finalpratical[i], finaltheory[i]);
            teacherDao.updatemarks(m);
        }
        return "redirect:/teacherhomepage";
    }

    @RequestMapping("/marksedit/{id}")
    public String marksedit(@PathVariable("id") int id, Model model) {
        Marks m = teacherDao.getById(id);
        model.addAttribute("marks", m);
        return "singlemarksedit";
    }

    @RequestMapping(value = "/updatemarks/{id}")
    public String updatesinglemarks(@RequestParam("id") int id, @RequestParam("roll") String roll, @RequestParam("semesterid") int semesterid, @RequestParam("subjectcode") String subjectcode, @RequestParam("internalpratical") int internalpratical, @RequestParam("internaltheory") int internaltheory, @RequestParam("finalpratical") int finalpratical, @RequestParam("finaltheory") int finaltheory) {

        Marks m = new Marks(id, roll, semesterid, subjectcode, internalpratical, internaltheory, finalpratical, finaltheory);
        teacherDao.updatemarks(m);
        return "redirect:/marksview";
    }

    @RequestMapping("/attendance")
    public String entryattendance(Model model) {
        String teacherid = (String) session.getAttribute("teacherid");
        List<Teachersubject> tlist = teacherDao.viewteacher(teacherid);
        System.out.println("teacher" + tlist);
        model.addAttribute("list", tlist);
        return "takeattendance";
    }

    @RequestMapping(value = "/addattendance", method = RequestMethod.POST)
    public String addattendance(@RequestParam("subjectcode") String subjectcode, @RequestParam("facultyid") String facultyid, @RequestParam("batchid") String batchid, Model model) {

        int batchid1 = Integer.parseInt(batchid);
        List<Studentdb> list = teacherDao.viewstudent(facultyid, batchid1);
        int semlist = teacherDao.viewsemeterid(facultyid, subjectcode);
        int sid = teacherDao.getsemesterid(batchid1, facultyid);
        if(semlist==sid){
            model.addAttribute("semlist", semlist);
        model.addAttribute("stlist", list);
        model.addAttribute("sublist", subjectcode);
        model.addAttribute("attendance", new Attendance());
        return "attendance";
        }else{
            model.addAttribute("msg", "select valid data");
            return "redirect:/attendance";
        }
        
    }

    @RequestMapping(value = "/insertattendance", method = RequestMethod.POST)
    public String insertattendance(@RequestParam("roll") String roll[], @RequestParam("subjectcode") String subjectcode, 
            @RequestParam("semesterid") String semesterid, @RequestParam("attendance") String attendance[],
            @RequestParam("remarks") String remarks[], @RequestParam("date") String date, Model model) {

        int semid = Integer.parseInt(semesterid);
        
        System.out.println("===============" + roll.length);
        model.addAttribute("msg", "Data saved");
        

        for (int i = 0; i < attendance.length; i++) {
            int batchid=teacherDao.getbatch(roll[i]);
            Attendance a = new Attendance(0, roll[i], semid, date, subjectcode, Boolean.parseBoolean(attendance[i]), remarks[i],batchid);
            teacherDao.insertattendance(a);
        }

        return "redirect:/attendance";
    }
    
    @RequestMapping(value="/viewattendance")
    public String viewattendance(Model model){
        String teacherid = (String) session.getAttribute("teacherid");
        List<Teachersubject> tlist = teacherDao.viewteacher(teacherid);
        System.out.println("teacher" + tlist);
        model.addAttribute("tlist", tlist);
        return "viewattendance";
    }
    
    @RequestMapping(value="/attendanceview")
    public String attendanceview(Model model,@RequestParam("batchid") int batchid,@RequestParam("facultyid") String facultyid,@RequestParam("subjectcode") String subjectcode){
        int semid = teacherDao.viewsemeterid(facultyid, subjectcode);
        List<Studentdb> stlist=teacherDao.viewstudent(facultyid, batchid);
        System.out.println("stlist====="+stlist.size());
        List<String> dlist=teacherDao.getdate(subjectcode, semid,batchid);
         model.addAttribute("date", dlist);
         model.addAttribute("semesterid", semid);
         model.addAttribute("subjectcode", subjectcode);
        List<Attend> atlist=new ArrayList<Attend>();
        for(int j=0;j<stlist.size();j++){
            Attend at=new Attend();
            at.setS(stlist.get(j));
            List<Attendance> list=new ArrayList<Attendance>();
            for(int i=0;i<dlist.size();i++){
                
            Attendance attendance = teacherDao.getattend(subjectcode, stlist.get(j).getRoll(),dlist.get(i));
            list.add(attendance);
        }
            at.setAttendance(list);
            atlist.add(at);
        }
        model.addAttribute("atlist", atlist);
        
        return "attendview";
    }

}
