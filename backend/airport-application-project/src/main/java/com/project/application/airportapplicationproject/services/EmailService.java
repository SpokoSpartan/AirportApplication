package com.project.application.airportapplicationproject.services;

import java.util.logging.Logger;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService{
    
    public JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            
        	Logger logger = Logger.getLogger(getClass().getName());

        	SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            
            logger.warning(message.toString());
            logger.warning(javaMailSender.toString());
            
            javaMailSender.send(message);
        } catch (MailException exception) {
            
        	exception.printStackTrace();
        }
    }
}