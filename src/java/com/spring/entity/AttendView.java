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
public class AttendView {
    private Studentdb student;
    private List<Subject> subject;
    private List<Integer> total;
    private List<Integer> present;

    public AttendView() {
    }

    public AttendView(Studentdb student, List<Subject> subject, List<Integer> total, List<Integer> present) {
        this.student = student;
        this.subject = subject;
        this.total = total;
        this.present = present;
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

    public List<Integer> getTotal() {
        return total;
    }

    public void setTotal(List<Integer> total) {
        this.total = total;
    }

    public List<Integer> getPresent() {
        return present;
    }

    public void setPresent(List<Integer> present) {
        this.present = present;
    }
    
    
    
}
