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
public class StudentSubMark {
    private Studentdb student;
    private List<Subject> subject;
    private List<Marks> mark;

    public StudentSubMark() {
    }

    public StudentSubMark(Studentdb student, List<Subject> subject, List<Marks> mark) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }
    
    

    public Studentdb getStudent() {
        return student;
    }

    public void setStudent(Studentdb student) {
        this.student = student;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public List<Marks> getMark() {
        return mark;
    }

    public void setMark(List<Marks> mark) {
        this.mark = mark;
    }
    
    
    
}
