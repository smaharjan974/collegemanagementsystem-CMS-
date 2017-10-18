/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "subjectcode")
    private String subjectcode;
    @Column(name = "subjectname")
    private String subjectname;
    @Column(name = "fullmarks")
    private Integer fullmarks;
    @Column(name = "passmarks")
    private Integer passmarks;
    @OneToMany(mappedBy = "subjectcode")
    private List<Marks> marksList;
    @OneToMany(mappedBy = "subjectcode")
    private List<Semester> semesterList;
    @OneToMany(mappedBy = "subjectcode")
    private List<Teachersubject> teachersubjectList;
    @OneToMany(mappedBy = "subjectcode")
    private List<Attendance> attendanceList;

    public Subject() {
    }

    public Subject(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public Integer getFullmarks() {
        return fullmarks;
    }

    public void setFullmarks(Integer fullmarks) {
        this.fullmarks = fullmarks;
    }

    public Integer getPassmarks() {
        return passmarks;
    }

    public void setPassmarks(Integer passmarks) {
        this.passmarks = passmarks;
    }

    public List<Marks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    public List<Teachersubject> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<Teachersubject> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectcode != null ? subjectcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectcode == null && other.subjectcode != null) || (this.subjectcode != null && !this.subjectcode.equals(other.subjectcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Subject[ subjectcode=" + subjectcode + " ]";
    }
    
}
