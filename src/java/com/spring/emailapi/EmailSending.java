/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.emailapi;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author SANJAY
 */
public class EmailSending {

    public EmailSending(String to, String username, String password) throws EmailException {
        String msg = "Your username is " + username + " and password is : " + password + "Login Daily to see your Attendance"
                + "Marks and others activities at infovista";
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication("infovistacms@gmail.com", "cmstheinfovista");
        email.setSSLOnConnect(true);
        email.setFrom("infovistacms@gmail.com");
        email.setSubject("Info vista added you! Try login");
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }
}
