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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "marks")
@NamedQueries({
    @NamedQuery(name = "Marks.findAll", query = "SELECT m FROM Marks m")})
public class Marks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name="roll")
    private String roll;
    @Column(name="subjectcode")
    private String subjectcode;
    @Column(name="semesterid")
    private Integer semesterid;
    @Column(name = "internalpratical")
    private Integer internalpratical;
    @Column(name = "internaltheory")
    private Integer internaltheory;
    @Column(name = "finalpratical")
    private Integer finalpratical;
    @Column(name = "finaltheory")
    private Integer finaltheory;

    public Marks() {
    }

    public Marks(Integer id, String roll,Integer semesterid, String subjectcode, Integer internalpratical, Integer internaltheory, Integer finalpratical, Integer finaltheory) {
        this.id = id;
        this.roll = roll;
        this.subjectcode = subjectcode;
        this.semesterid = semesterid;
        this.internalpratical = internalpratical;
        this.internaltheory = internaltheory;
        this.finalpratical = finalpratical;
        this.finaltheory = finaltheory;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }
    
    

    public Marks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInternalpratical() {
        return internalpratical;
    }

    public void setInternalpratical(Integer internalpratical) {
        this.internalpratical = internalpratical;
    }

    public Integer getInternaltheory() {
        return internaltheory;
    }

    public void setInternaltheory(Integer internaltheory) {
        this.internaltheory = internaltheory;
    }

    public Integer getFinalpratical() {
        return finalpratical;
    }

    public void setFinalpratical(Integer finalpratical) {
        this.finalpratical = finalpratical;
    }

    public Integer getFinaltheory() {
        return finaltheory;
    }

    public void setFinaltheory(Integer finaltheory) {
        this.finaltheory = finaltheory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marks)) {
            return false;
        }
        Marks other = (Marks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.entity.Marks[ id=" + id + " ]";
    }
    
}
