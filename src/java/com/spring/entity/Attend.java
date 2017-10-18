/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import java.util.List;

/**
 *
 * @author SANJAY
 */
public class Attend {
    private Studentdb s;
    private List<Attendance> attendance;
    
    
   

    public Attend() {
    }

    public Attend(Studentdb s, List<Attendance> attendance) {
        this.s = s;
        this.attendance = attendance;
    }
    
    

    public Studentdb getS() {
        return s;
    }

    public void setS(Studentdb s) {
        this.s = s;
    }
    
     public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
    
    
}
