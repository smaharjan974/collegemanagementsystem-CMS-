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
public class SubjectTotal {
    Subject subject;
    Integer Totaldays;

    public SubjectTotal() {
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getTotaldays() {
        return Totaldays;
    }

    public void setTotaldays(Integer Totaldays) {
        this.Totaldays = Totaldays;
    }
    
    
}
