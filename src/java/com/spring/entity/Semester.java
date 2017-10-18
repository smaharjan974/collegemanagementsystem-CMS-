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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "semester")
@NamedQueries({
    @NamedQuery(name = "Semester.findAll", query = "SELECT s FROM Semester s")})
public class Semester  {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="semesterid")
    private int semesterid;
    @Column(name = "facultyid")
    private String facultyid;
    @Column(name = "subjectcode")
    private String subjectcode;

    public Semester() {
    }

    public Semester(int id, int semesterid, String facultyid, String subjectcode) {
        this.id = id;
        this.semesterid = semesterid;
        this.facultyid = facultyid;
        this.subjectcode = subjectcode;
    }

    public Semester(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(int semesterid) {
        this.semesterid = semesterid;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }
  
    
    
}
