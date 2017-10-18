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
public class MarksSubject {
    private Subject subject;
    private List<Marks> marks;

    public MarksSubject() {
    }

    public MarksSubject(Subject subject, List<Marks> marks) {
        this.subject = subject;
        this.marks = marks;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
    
}
