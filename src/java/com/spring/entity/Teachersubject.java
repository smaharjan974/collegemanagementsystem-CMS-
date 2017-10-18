/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "teachersubject")
@NamedQueries({
    @NamedQuery(name = "Teachersubject.findAll", query = "SELECT t FROM Teachersubject t")})
public class Teachersubject implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id")
    private Integer id;
   @Column(name="subjectcode")
    private String subjectcode;
    @Column(name="teacherid")
    private String teacherid;
    @Column(name="facultyid")
    private String facultyid;
    @Column(name="batchid")
    private String batchid;

    public Teachersubject(Integer id, String subjectcode, String teacherid, String facultyid, String batchid) {
        this.id = id;
        this.subjectcode = subjectcode;
        this.teacherid = teacherid;
        this.facultyid = facultyid;
        this.batchid = batchid;
    }
    
    

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public Teachersubject() {
    }

    
    public Teachersubject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    
}
