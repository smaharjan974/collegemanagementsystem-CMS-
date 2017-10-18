/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;


import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "studentdb")
@NamedQueries({
    @NamedQuery(name = "Studentdb.findAll", query = "SELECT s FROM Studentdb s")})
public class Studentdb {

    
    
    @Id
    @Column(name = "roll")
    private String roll;
    @Column(name = "sfirstname")
    private String sfirstname;
    @Column(name = "slastname")
    private String slastname;
    @Column(name = "sgender")
    private String sgender;
    @Column(name = "sDOB")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date sDOB;
     @Column(name = "facultyid")
    private String facultyid;
      @Column(name = "batchid")
    private int batchid;
    @Column(name = "saddress")
    private String saddress;
    @Column(name = "scontact")
    private String scontact;
    @Column(name = "bloodgroup")
    private String bloodgroup;
    @Column(name = "semail")
    private String semail;
    @Column(name = "password")
    private String password;
    @Column(name = "gfirstname")
    private String gfirstname;
    @Column(name = "glastname")
    private String glastname;
    @Column(name = "relation")
    private String relation;
    @Column(name = "contact")
    private String contact;
    @Column(name = "gemail")
    private String gemail;
    
    public Studentdb() {
    }

    public Studentdb(String roll) {
        this.roll = roll;
    }

    
    public Studentdb(String roll, String sfirstname, String slastname, String sgender, Date sDOB, String facultyid, int batchid, String saddress, String scontact, String bloodgroup, String semail, String password, String gfirstname, String glastname, String relation, String contact, String gemail) {
        this.roll = roll;
        this.sfirstname = sfirstname;
        this.slastname = slastname;
        this.sgender = sgender;
        this.sDOB = sDOB;
        this.facultyid = facultyid;
        this.batchid = batchid;
        this.saddress = saddress;
        this.scontact = scontact;
        this.bloodgroup = bloodgroup;
        this.semail = semail;
        this.password = password;
        this.gfirstname = gfirstname;
        this.glastname = glastname;
        this.relation = relation;
        this.contact = contact;
        this.gemail = gemail;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getSfirstname() {
        return sfirstname;
    }

    public void setSfirstname(String sfirstname) {
        this.sfirstname = sfirstname;
    }

    public String getSlastname() {
        return slastname;
    }

    public void setSlastname(String slastname) {
        this.slastname = slastname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Date getsDOB() {
        return sDOB;
    }

   
    public void setsDOB(Date sDOB) {
       
        this.sDOB = sDOB;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getScontact() {
        return scontact;
    }

    public void setScontact(String scontact) {
        this.scontact = scontact;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGfirstname() {
        return gfirstname;
    }

    public void setGfirstname(String gfirstname) {
        this.gfirstname = gfirstname;
    }

    public String getGlastname() {
        return glastname;
    }

    public void setGlastname(String glastname) {
        this.glastname = glastname;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGemail() {
        return gemail;
    }

    public void setGemail(String gemail) {
        this.gemail = gemail;
    }
    
    
}
