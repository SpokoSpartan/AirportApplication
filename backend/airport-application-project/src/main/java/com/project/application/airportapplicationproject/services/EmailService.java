package com.project.application.airportapplicationproject.services;

import com.project.application.airportapplicationproject.DTOs.Email;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;


import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final SendEmailService sendEmailService;

    @Async
    public void sendSimpleMessage(Email email, List<String> recipients) {

        if(recipients.size()  > 0) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipients.toArray(new String[0]));
            message.setSubject(email.getSubject());
            message.setText(email.getMessageContext());
            try {
                sendEmailService.send(message);
            }
            catch(MailException e){
                // attempts to send an email failed
                // skip the problem
            }
        }
    }
}