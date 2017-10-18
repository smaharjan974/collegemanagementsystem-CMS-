/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

/**
 *
 * @author SANJAY
 */
public class AttendanceStd {
    private Subject subject;
    private Integer totaldays;
    private Integer present;

    public AttendanceStd() {
    }

    public AttendanceStd(Subject subject, Integer totaldays, Integer present) {
        this.subject = subject;
        this.totaldays = totaldays;
        this.present = present;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(Integer totaldays) {
        this.totaldays = totaldays;
    }

    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer present) {
        this.present = present;
    }
    
    
    
    
}
