/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author SANJAY
 */
@Entity
@Table(name = "admindb")
@NamedQueries({
    @NamedQuery(name = "Admindb.findAll", query = "SELECT a FROM Admindb a")})
public class Admindb implements Serializable {

    
    @Id
    @Column(name="adminusername")
    private String adminusername;
    @Column(name = "adminpassword")
    private String adminpassword;

    public Admindb() {
    }

    public Admindb(String adminusername, String adminpassword) {
        this.adminusername = adminusername;
        this.adminpassword = adminpassword;
    }

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }
    
    
   
    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

  
}
