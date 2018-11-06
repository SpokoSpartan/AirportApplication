package com.project.application.airportapplicationproject.email;

import java.io.File;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

//@Component
//@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

	@Autowired
    public JavaMailSender javaMailSender;

    @Override
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

    @Override
    public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String ...templateArgs) {
        
    	String text = String.format(template.getText(), templateArgs);  
        sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
        
    	try {
          
        	MimeMessage message = javaMailSender.createMimeMessage();
          
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);

            javaMailSender.send(message);
        } catch (MessagingException e) {
           
        	e.printStackTrace();
        }
    }
}