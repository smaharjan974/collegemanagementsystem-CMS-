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
@Table(name = "batch")
@NamedQueries({
    @NamedQuery(name = "Batch.findAll", query = "SELECT b FROM Batch b")})
public class Batch  {

    
    @Id
    @Column(name = "batchid")
    private Integer batchid;
    @Column(name = "batchname")
    private String batchname;
   

    public Batch() {
    }

    public Batch(Integer batchid, String batchname) {
        this.batchid = batchid;
        this.batchname = batchname;
    }
    

    public Batch(Integer batchid) {
        this.batchid = batchid;
    }

    public Integer getBatchid() {
        return batchid;
    }

    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

  
}
