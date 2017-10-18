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
@Table(name = "semestername")
@NamedQueries({
    @NamedQuery(name = "Semestername.findAll", query = "SELECT s FROM Semestername s")})
public class Semestername implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "semesterid")
    private Integer semesterid;
    @Column(name = "semestername")
    private String semestername;
    @OneToMany(mappedBy = "semesterid")
    private List<Batchsemster> batchsemsterList;
    @OneToMany(mappedBy = "semesterid")
    private List<Semester> semesterList;
    @OneToMany(mappedBy = "semesterid")
    private List<Attendance> attendanceList;

    public Semestername() {
    }

    public Semestername(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername;
    }

    public List<Batchsemster> getBatchsemsterList() {
        return batchsemsterList;
    }

    public void setBatchsemsterList(List<Batchsemster> batchsemsterList) {
        this.batchsemsterList = batchsemsterList;
    }

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
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
        hash += (semesterid != null ? semesterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestername)) {
            return false;
        }
        Semestername other = (Semestername) object;
        if ((this.semesterid == null && other.semesterid != null) || (this.semesterid != null && !this.semesterid.equals(other.semesterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Semestername[ semesterid=" + semesterid + " ]";
    }
    
}
