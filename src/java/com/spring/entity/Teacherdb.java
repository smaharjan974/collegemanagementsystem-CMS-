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
@Table(name = "teacherdb")
@NamedQueries({
    @NamedQuery(name = "Teacherdb.findAll", query = "SELECT t FROM Teacherdb t")})
public class Teacherdb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacherid")
    private String teacherid;
    @Column(name = "tfirstname")
    private String tfirstname;
    @Column(name = "tlastname")
    private String tlastname;
    @Column(name = "tgender")
    private String tgender;
    @Column(name = "tcontact")
    private String tcontact;
    @Column(name = "taddress")
    private String taddress;
    @Column(name = "temail")
    private String temail;
    @Column(name = "tpassword")
    private String tpassword;
    @OneToMany(mappedBy = "teacherid")
    private List<Teachersubject> teachersubjectList;

    public Teacherdb() {
    }

    public Teacherdb(String teacherid, String tfirstname, String tlastname, String tgender, String tcontact, String taddress, String temail, String tpassword, List<Teachersubject> teachersubjectList) {
        this.teacherid = teacherid;
        this.tfirstname = tfirstname;
        this.tlastname = tlastname;
        this.tgender = tgender;
        this.tcontact = tcontact;
        this.taddress = taddress;
        this.temail = temail;
        this.tpassword = tpassword;
        this.teachersubjectList = teachersubjectList;
    }
    
    

    public Teacherdb(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTfirstname() {
        return tfirstname;
    }

    public void setTfirstname(String tfirstname) {
        this.tfirstname = tfirstname;
    }

    public String getTlastname() {
        return tlastname;
    }

    public void setTlastname(String tlastname) {
        this.tlastname = tlastname;
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public String getTcontact() {
        return tcontact;
    }

    public void setTcontact(String tcontact) {
        this.tcontact = tcontact;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public List<Teachersubject> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<Teachersubject> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacherdb)) {
            return false;
        }
        Teacherdb other = (Teacherdb) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Teacherdb[ teacherid=" + teacherid + " ]";
    }
    
}
