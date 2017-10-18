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
@Table(name = "faculty")
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f")})
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "facultyid")
    private String facultyid;
    @Column(name = "facultyname")
    private String facultyname;
    @Column(name = "semestercount")
    private Integer semestercount;
    @OneToMany(mappedBy = "facultyid")
    private List<Semester> semesterList;
    @OneToMany(mappedBy = "facultyid")
    private List<Studentdb> studentdbList;

    public Faculty() {
    }

    public Faculty(String facultyid, String facultyname, Integer semestercount, List<Semester> semesterList, List<Studentdb> studentdbList) {
        this.facultyid = facultyid;
        this.facultyname = facultyname;
        this.semestercount = semestercount;
        this.semesterList = semesterList;
        this.studentdbList = studentdbList;
    }
    
     

    public Faculty(String facultyid) {
        this.facultyid = facultyid;
    }

    

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public Integer getSemestercount() {
        return semestercount;
    }

    public void setSemestercount(Integer semestercount) {
        this.semestercount = semestercount;
    }

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    public List<Studentdb> getStudentdbList() {
        return studentdbList;
    }

    public void setStudentdbList(List<Studentdb> studentdbList) {
        this.studentdbList = studentdbList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyid != null ? facultyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyid == null && other.facultyid != null) || (this.facultyid != null && !this.facultyid.equals(other.facultyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Faculty[ facultyid=" + facultyid + " ]";
    }
    
}
