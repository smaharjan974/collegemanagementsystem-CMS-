/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.dao.AdminDao;
import com.spring.entity.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SANJAY
 */
@Controller
public class Main {
    @Autowired
    AdminDao adminDao;
    
    @RequestMapping("/")
    public String inde(Model model){
        List<Event> e = adminDao.getevent();
        System.out.println("========="+e.size());
        model.addAttribute("event", e);
        return "index";
    }
    } 
