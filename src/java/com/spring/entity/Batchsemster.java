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
@Table(name = "batchsemster")
@NamedQueries({
    @NamedQuery(name = "Batchsemster.findAll", query = "SELECT b FROM Batchsemster b")})
public class Batchsemster implements Serializable {

   @Id
   @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name="batchid")
    private int batchid;
    @Column(name="semesterid")
    private int semesterid;

    @Column(name="facultyid")
    private String facultyid;
    
    
    public Batchsemster() {
    }

    public Batchsemster(int id) {
        this.id = id;
    }
    

    public Batchsemster(int id, int batchid, int semesterid,String facultyid) {
        this.id = id;
        this.batchid = batchid;
        this.semesterid = semesterid;
        this.facultyid = facultyid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
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

    
    
}
