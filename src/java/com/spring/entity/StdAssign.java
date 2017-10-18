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
public class StdAssign {
    
    private Teacherdb teacher;
    private Subject subject;
    private List<Assignment> details;

    public StdAssign() {
    }
    

    public StdAssign(Teacherdb teacher, Subject subject, List<Assignment> details) {
        this.teacher = teacher;
        this.subject = subject;
        this.details = details;
    }
    
    

    public Teacherdb getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacherdb teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Assignment> getDetails() {
        return details;
    }

    public void setDetails(List<Assignment> details) {
        this.details = details;
    }
    
    
    
}
