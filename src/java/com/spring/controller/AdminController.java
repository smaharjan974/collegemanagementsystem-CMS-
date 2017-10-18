package com.spring.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.spring.ID3A.ID3;

import com.spring.dao.AdminDao;
import com.spring.dao.TeacherDao;
import com.spring.emailapi.EmailSending;
import com.spring.entity.Admindb;
import com.spring.entity.AttendView;
import com.spring.entity.Batch;
import com.spring.entity.Batchsemster;
import com.spring.entity.Event;
import com.spring.entity.Faculty;
import com.spring.entity.Marks;
import com.spring.entity.Semester;
import com.spring.entity.Semestername;
import com.spring.entity.StudentSubMark;
import com.spring.entity.Studentdb;
import com.spring.entity.Subject;
import com.spring.entity.SubjectTotal;
import com.spring.entity.Teacherdb;
import com.spring.entity.Teachersubject;
import java.io.File;
import java.nio.file.Files;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.mail.EmailException;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
public class AdminController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    AdminDao adminDao;

    @Autowired
    HttpSession session;

    @Autowired
    TeacherDao teacherDao;

    @RequestMapping("/adminlogin")
    public String adminlogin() {
        return "adminlogin";
    }

    @RequestMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    public String adminlogincheck(@RequestParam("adminusername") String adminusername, @RequestParam("adminpassword") String adminpassword) {
        Admindb admin = adminDao.checklogin(adminusername, adminpassword);
        if (admin != null) {
            session.setAttribute("adminusername", adminusername);
            session.setAttribute("name", admin.getAdminusername());
            return "redirect:/homepage";
        } else {
            return "redirect:/adminlogin";
        }
    }

    @RequestMapping("/homepage")
    public String homepage() {
        return "dashboard";
    }

    @RequestMapping("/addstudent")
    public String addstudent(Model model) {

        List<Studentdb> list = adminDao.viewstudent();

        DateFormat df1 = new SimpleDateFormat("mm-dd-yyyy");
        DateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");

        for (Studentdb x : list) {
            try {
                Date d1 = df2.parse(df2.format(x.getsDOB()));
                x.setsDOB(d1);
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        List<Faculty> facultylist = adminDao.viewfaculty();

        model.addAttribute("facultylist", facultylist);

        List<Batch> batchlist = adminDao.viewbatch();
        model.addAttribute("batchlist", batchlist);

        model.addAttribute("studentlist", new Studentdb());

        return "studententry";
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String _addstudent(@ModelAttribute("studentlist") Studentdb student, @RequestParam("roll") String roll, @RequestParam("semail") String semail, @RequestParam("password") String password, @RequestParam("gemail") String gemail, Model model) throws EmailException {
        boolean check = false;
        try {
             check= adminDao.insertstudent(student);
            EmailSending s = new EmailSending(semail, roll, password);
            EmailSending sa = new EmailSending(gemail, roll, password);

        } catch (Exception e) {
            
        }
        if (check) {
            model.addAttribute("msg", "Reqistered and email sent!!!");
            return "redirect:/addstudent";
        } else {
             model.addAttribute("msg", "student not inserted");
            return "dashboard";
        }

    }

    @RequestMapping(value = "/viewstudent", method = RequestMethod.GET)
    public String viewstudent(Model model) {
        List<Studentdb> studentlist = adminDao.viewstudent();

        model.addAttribute("studentlist", studentlist);
        model.addAttribute("student", new Studentdb());

        return "viewstudent";
    }

    @RequestMapping("/deletestudent/{roll}")
    public String deletestudent(@PathVariable("roll") String roll) {
        System.out.println("roll : " + roll);
        adminDao.deletestudent(roll);
        return "redirect:/viewstudent";
    }

    @RequestMapping("/addteacher")
    public String addteacher(Model model) {

        model.addAttribute("teacherlist", new Teacherdb());

        return "teacherentry";
    }

    @RequestMapping(value = "/viewteacher", method = RequestMethod.GET)
    public String viewteacher(Model model) {
        List<Teacherdb> teacherlist = adminDao.viewteacher();

        model.addAttribute("teacherlist", teacherlist);
        model.addAttribute("teacher", new Teacherdb());

        return "viewteacher";
    }

    @RequestMapping(value = "/addteacher", method = RequestMethod.POST)
    public String _addteacher(@ModelAttribute("teacherlist") Teacherdb teacher, @RequestParam("temail") String temail, @RequestParam("tpassword") String tpassword, @RequestParam("teacherid") String teacherid, Model model) throws EmailException {

        boolean check = adminDao.insertteacher(teacher);
        EmailSending t = new EmailSending(temail, teacherid, tpassword);

        if (check) {
            model.addAttribute("msg", "Teacher Registered and email Sent!!!");
            return "redirect:/addteacher";
        } else {
            model.addAttribute("msg", "Register not successfull");
            return "dashboard";
        }

    }

    @RequestMapping("/deleteteacher/{teacherid}")
    public String deleteteacher(@PathVariable("teacherid") String teacherid) {
        adminDao.deleteteacher(teacherid);
        return "redirect:/viewteacher";
    }

    @RequestMapping("/subjectteacher")
    public String teachertaught(Model model) {
        model.addAttribute("subteacher", new Teachersubject());
        return "subjectteaches";
    }

    @RequestMapping(value = "/subjectteacher", method = RequestMethod.POST)
    public String _teachertaught(@ModelAttribute("subteacher") Teachersubject subteacher) {
        boolean check = adminDao.insertsubjectteacher(subteacher);
        if (check) {
            return "redirect:/subjectteacher?msg=inserted";
        } else {
            return "redirect:/subjectteacher?msg=not inserted";
        }
    }

    @RequestMapping("/viewsubjecttaught")
    public String viewteachertaught(Model model) {
        List<Teachersubject> teachersublist = adminDao.viewteacherteaches();
        model.addAttribute("teachersublist", teachersublist);
        model.addAttribute("teachersub", new Teachersubject());
        return "viewteachersubject";
    }

    @RequestMapping("/deletesubjecttaught/{id}")
    public String deletesubjecttaught(@PathVariable("id") int id) {
        adminDao.deletesubjecttaught(id);
        return "redirect:/viewsubjecttaught";
    }

    @RequestMapping("/addfaculty")
    public String addfaculty(Model model) {

        model.addAttribute("faculty", new Faculty());

        return "facultyentry";
    }

    @RequestMapping(value = "/addfaculty", method = RequestMethod.POST)
    public String _addfaculty(@ModelAttribute("faculty") Faculty faculty) {

        boolean check = adminDao.insertfaculty(faculty);
        if (check) {
            return "redirect:/addfaculty";
        } else {
            return "dashboard";
        }

    }

    @RequestMapping(value = "/viewfaculty", method = RequestMethod.GET)
    public String viewfaculty(Model model) {
        List<Faculty> facultylist = adminDao.viewfaculty();

        model.addAttribute("facultylist", facultylist);
        model.addAttribute("faculty", new Faculty());

        return "viewfaculty";
    }

    @RequestMapping(value = "/deletefaculty/{facultyid}")
    public String deletefaculty(@PathVariable("facultyid") String facultyid) {
        adminDao.deletefaculty(facultyid);
        return "redirect:/viewfaculty";
    }

    @RequestMapping("/addsubject")
    public String addsubject(Model model) {

        model.addAttribute("subject", new Subject());

        return "subjectentry";
    }

    @RequestMapping(value = "/addsubject", method = RequestMethod.POST)
    public String _addsubject(@ModelAttribute("subject") Subject subject) {

        boolean check = adminDao.insertsubject(subject);

        if (check) {
            return "redirect:/addsubject";
        } else {
            return "dashboard";
        }

    }

    @RequestMapping(value = "/viewsubject", method = RequestMethod.GET)
    public String viewsubject(Model model) {
        List<Subject> subjectlist = adminDao.viewsubject();

        model.addAttribute("subejctlist", subjectlist);

        return "viewsubject";
    }

    @RequestMapping("/deletesubject/{subjectcode}")
    public String deletesubject(@PathVariable("subjectcode") String subjectcode) {
        adminDao.deletesubject(subjectcode);
        return "redirect:/viewsubject";
    }

    @RequestMapping(value = "/addbatch", method = RequestMethod.GET)
    public String addbatch(Model model) {

        model.addAttribute("batchlist", new Batch());
        return "batchentry";
    }

    @RequestMapping(value = "/addbatch", method = RequestMethod.POST)
    public String _addbatch(@ModelAttribute("batchlist") Batch batch) {

        boolean check = adminDao.insertbatch(batch);
        if (check) {
            return "redirect:/addbatch";
        } else {
            return "dashboard";
        }
    }

    @RequestMapping(value = "/viewbatch", method = RequestMethod.GET)
    public String viewbatch(Model model) {
        List<Batch> batchlist = adminDao.viewbatch();

        model.addAttribute("batchlist", batchlist);
        model.addAttribute("batch", new Batch());

        return "viewbatch";
    }

    @RequestMapping("/deletebatch/{batchid}")
    public String deletebatch(@PathVariable("batchid") int batchid) {

        adminDao.deletebatch(batchid);
        return "redirect:/viewbatch";
    }

    @RequestMapping(value = "/editbatch/{batchid}")
    public String editbatch(@PathVariable("batchid") int batchid, Model model) {
        Batch batch = adminDao.getBatchById(batchid);
        model.addAttribute("batch", batch);
        model.addAttribute("batchl", new Batch());

        return "editbatch";
    }

    @RequestMapping(value = "/updatebatch/{batchid}", method = RequestMethod.POST)
    public String updatebatch(Batch batch) {

        adminDao.updatebatch(batch);
        return "redirect:/viewbatch";
    }

    @RequestMapping(value = "/addsemester", method = RequestMethod.GET)
    public String addsemester(Model model) {
        List<Faculty> facultylist = adminDao.viewfaculty();
        model.addAttribute("facultylist", facultylist);
        List<Subject> subjectlist = adminDao.viewsubject();
        model.addAttribute("subjectlist", subjectlist);
        List<Semestername> semesternamelist = adminDao.viewsemestername();
        model.addAttribute("semesternamelist", semesternamelist);
        return "semesterentry";
    }

    @RequestMapping(value = "/addsemester", method = RequestMethod.POST)
    public String _addsemester(@ModelAttribute("semesterlist") Semester semester) {

        boolean check = adminDao.insertsemester(semester);
        if (check) {
            return "redirect:/addsemester";
        } else {
            return "dashboard";
        }
    }

    @RequestMapping(value = "/viewsemester", method = RequestMethod.GET)
    public String viewsemester(Model model) {
        List<Semester> batchlist = adminDao.viewsemester();
        model.addAttribute("semesterlist", batchlist);
        return "viewsemester";
    }

    @RequestMapping("/viewbatchsemsub")
    public String batchsemsub(Model model) {
        List<Faculty> faclist = adminDao.viewfaculty();
        model.addAttribute("faclist", faclist);
        List<Semestername> semname = adminDao.viewsemestername();
        model.addAttribute("semlist", semname);
        return "viewbatchsemsub";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String show(@RequestParam("facultyid") String facultyid, @RequestParam("semesterid") String id, Model model) {
        try {
            int semid = Integer.parseInt(id);
            model.addAttribute("fac", facultyid);
            model.addAttribute("semid", semid);
            List<String> sublist = adminDao.getsubjectcode(semid, facultyid);
            List<Subject> sub = new ArrayList<Subject>();
            for (int i = 0; i < sublist.size(); i++) {
                Subject s = adminDao.getsubjectlist(sublist.get(i));
                sub.add(s);
            }
            model.addAttribute("sublist", sub);
        } catch (Exception e) {
        }
        return "showbatchsemsub";
    }

    @RequestMapping(value = "/deletesemester/{id}")
    public String deletesemester(@PathVariable("id") int id) {
        adminDao.deletesemester(id);
        return "redirect:/viewsemester";
    }

    @RequestMapping("/addevent")
    public String addevent(Model model) {
        model.addAttribute("event", new Event());
        return "addevent";
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.POST)
    public String _addevent(Model model) throws Exception {

        String path = request.getServletContext().getRealPath("") + "/resources/eventimage";

        MultipartRequest mrequest = new MultipartRequest(request, path, 3000000, new FileRenamePolicy() {
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
        if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("png")) {
            String type = mrequest.getParameter("type");
            String name = mrequest.getParameter("name");
            String venue = mrequest.getParameter("venue");
            String date = mrequest.getParameter("date");
            String details = mrequest.getParameter("details");
            Event e = new Event(0, type, name, date, venue, details, filename);
            adminDao.insertevent(e);
            model.addAttribute("postmsg", "inserted successfully");
        } else {
            Files.delete(new File(path + "/" + filename).toPath());
            model.addAttribute("postmsg", "invalid format");

        }
        return "redirect:/addevent";
    }

    @RequestMapping("/viewevent")
    public String viewevent(Model model) {
        List<Event> list = adminDao.getevent();
        model.addAttribute("list", list);
        return "viewevent";
    }

    @RequestMapping("/deleteevent/{id}")
    public String deleteevent(@PathVariable("id") int id) {
        adminDao.deleteevent(id);
        return "redirect:/viewevent";
    }

    @RequestMapping("/addbatchsem")
    public String addbatchsem(Model model) {

        model.addAttribute("bathchsem", new Batchsemster());
        return "batchsemester";
    }

    @RequestMapping(value = "/addbatchsem", method = RequestMethod.POST)
    public String _addbatchsem(@ModelAttribute("batchsem") Batchsemster batchsem) {

        boolean check = adminDao.insertbatchsem(batchsem);

        if (check) {
            return "redirect:/addbatchsem?msg=inserted successfully";

        } else {
            return "redirect:/addbatchsem?msg=not inserted successfully";
        }
    }

    @RequestMapping("/viewbatchsem")
    public String viewbatchsem(Model model) {
        List<Batchsemster> batchsemlist = adminDao.viewbatchsem();

        model.addAttribute("batchsemlist", batchsemlist);
        model.addAttribute("batch", new Batchsemster());
        return "viewbatchsemester";
    }

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    public String progressbatchsem() {
        List<Batchsemster> list = adminDao.viewbatchsem();

        for (Batchsemster b : list) {
            String facultyid = b.getFacultyid();
            int semesterid = b.getSemesterid();
            int batchid = b.getBatchid();

            List<Faculty> f = adminDao.getfacultyid(facultyid);
            for (Faculty abc : f) {
                abc.getSemestercount();

                if (abc.getSemestercount() > semesterid) {

                    semesterid = semesterid + 1;
                    System.out.println("semesterid" + semesterid);
                    System.out.println("asadf" + batchid + semesterid + facultyid + b.getId());
                    Batchsemster btsem = new Batchsemster(b.getId(), batchid, semesterid, facultyid);
                    adminDao.updatebatchsem(btsem);

                } else {
                    adminDao.deletebatchsem(b.getId());

                }
            }
        }
        return "redirect:/viewbatchsem";
    }

    @RequestMapping("/choosemarks")
    public String choosemarks(Model model) {
        List<Semestername> list = adminDao.viewsemestername();
        model.addAttribute("semlist", list);
        List<Faculty> faclist = adminDao.viewfaculty();
        model.addAttribute("faclist", faclist);
        List<Batch> batchlist = adminDao.viewbatch();
        model.addAttribute("batchlist", batchlist);
        return "choosemarks";
    }

    @RequestMapping(value = "/showmarksdetails", method = RequestMethod.POST)
    public String showmarksdetails(@RequestParam("selectmarks") String selectmarks, @RequestParam("batchid") int batchid, @RequestParam("facultyid") String facultyid, @RequestParam("semesterid") String semesterid, Model model) {

        int semesterid1 = Integer.parseInt(semesterid);

        if (selectmarks.equals("internalmarks")) {

            List<Studentdb> stlist = adminDao.getstudent(batchid, facultyid);
            model.addAttribute("stlist", stlist);

            List<String> subcode = adminDao.getsubjectcode(semesterid1, facultyid);

            List<Subject> name = new ArrayList<Subject>();
            for (int i = 0; i < subcode.size(); i++) {
                Subject s = adminDao.getsubjectlist(subcode.get(i));
                name.add(s);
            }

            List<StudentSubMark> mlist = new ArrayList<StudentSubMark>();
            model.addAttribute("subname", name);
            for (int i = 0; i < stlist.size(); i++) {
                StudentSubMark stu = new StudentSubMark();
                stu.setStudent(stlist.get(i));
                List<Marks> marksList = new ArrayList<Marks>();
                List<Subject> subjectList = new ArrayList<Subject>();
                for (int j = 0; j < name.size(); j++) {
                    Marks m = adminDao.getinternalmarks(stlist.get(i).getRoll(), semesterid1, subcode.get(j));
                    marksList.add(m);
                    subjectList.add(name.get(j));
                }
                stu.setSubject(subjectList);
                stu.setMark(marksList);
                mlist.add(stu);

            }
            model.addAttribute("marks", mlist);
            return "showinternalmarksdetails";
        } else if (selectmarks.equals("boardmarks")) {
            List<Studentdb> stlist = adminDao.getstudent(batchid, facultyid);
            model.addAttribute("stlist", stlist);

            List<String> subcode = adminDao.getsubjectcode(semesterid1, facultyid);

            List<Subject> name = new ArrayList<Subject>();
            for (int i = 0; i < subcode.size(); i++) {
                Subject s = adminDao.getsubjectlist(subcode.get(i));
                name.add(s);
            }

            List<StudentSubMark> mlist = new ArrayList<StudentSubMark>();
            model.addAttribute("subname", name);
            for (int i = 0; i < stlist.size(); i++) {
                StudentSubMark stu = new StudentSubMark();
                stu.setStudent(stlist.get(i));
                List<Marks> marksList = new ArrayList<Marks>();
                List<Subject> subjectList = new ArrayList<Subject>();
                for (int j = 0; j < name.size(); j++) {
                    Marks m = adminDao.getinternalmarks(stlist.get(i).getRoll(), semesterid1, subcode.get(j));
                    marksList.add(m);
                    subjectList.add(name.get(j));
                }
                stu.setSubject(subjectList);
                stu.setMark(marksList);
                mlist.add(stu);

            }
            model.addAttribute("marks", mlist);

            return "showboardmarksdetails";
        } else {
            model.addAttribute("msg", "Select Valid Data");
            return "redirect:/choosemarks";
        }
    }

    @RequestMapping("/attend")
    public String attend(Model model) {
        List<Semestername> list = adminDao.viewsemestername();
        model.addAttribute("semlist", list);
        List<Faculty> faclist = adminDao.viewfaculty();
        model.addAttribute("faclist", faclist);
        List<Batch> batchlist = adminDao.viewbatch();
        model.addAttribute("batchlist", batchlist);
        return "attend";
    }

    @RequestMapping(value = "/viewattend", method = RequestMethod.POST)
    public String attendview(@RequestParam("batchid") int batchid, @RequestParam("semesterid") int semesterid, @RequestParam("facultyid") String facultyid, Model model) {

        List<Studentdb> stlist = adminDao.getstudent(batchid, facultyid);
        List<String> subcode = adminDao.getsubjectcode(semesterid, facultyid);
        List<Subject> subject = new ArrayList<Subject>();
        for (int i = 0; i < subcode.size(); i++) {
            Subject s = adminDao.getsubjectlist(subcode.get(i));
            subject.add(s);
        }

        model.addAttribute("subject", subject);
        List<AttendView> attendview = new ArrayList<AttendView>();
        List<Integer> pdays = new ArrayList<Integer>();
        for (int i = 0; i < stlist.size(); i++) {
            SubjectTotal subtot = new SubjectTotal();
            AttendView attend = new AttendView();
            attend.setStudent(stlist.get(i));
            List<Subject> sub = new ArrayList<Subject>();
            List<Integer> total = new ArrayList<Integer>();
            List<Integer> present = new ArrayList<Integer>();

            for (int j = 0; j < subject.size(); j++) {
                List<String> date = teacherDao.getdate(subject.get(j).getSubjectcode(), semesterid, batchid);
                int totaldays = date.size();
                int count = 0;
                sub.add(subject.get(j));
                total.add(totaldays);
                for (int k = 0; k < totaldays; k++) {
                    boolean check = adminDao.getAttendance(stlist.get(i).getRoll(), subject.get(j).getSubjectcode(), date.get(k));
                    System.out.println(count + "===========" + stlist.get(i).getRoll() + subject.get(j).getSubjectcode() + date.get(k));
                    if (check) {
                        count = count + 1;
                    }

                }
                present.add(count);
                attend.setPresent(present);
                attend.setSubject(sub);
                attend.setTotal(total);

            }
            attendview.add(attend);
        }
        model.addAttribute("attend", attendview);

        List<SubjectTotal> subt = new ArrayList<SubjectTotal>();
        for (int i = 0; i < subject.size(); i++) {
            SubjectTotal sub = new SubjectTotal();
            sub.setSubject(subject.get(i));
            List<String> date = adminDao.getdate(subject.get(i).getSubjectcode(), batchid, semesterid);
            int totaldays = date.size();
            sub.setTotaldays(totaldays);
            subt.add(sub);
        }
        model.addAttribute("subject", subt);
        return "viewattend";
    }

    @RequestMapping("/prediction")
    public String predict() {

        ID3 id3 = new ID3();
        return "redirect:/homepage";
    }

}
