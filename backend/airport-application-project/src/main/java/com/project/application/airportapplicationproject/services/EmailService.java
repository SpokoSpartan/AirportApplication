package com.project.application.airportapplicationproject.services;

import com.project.application.airportapplicationproject.DTOs.Email;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService{
    
    private final JavaMailSender javaMailSender;

    @Retryable(
            value = MailException.class,
            maxAttempts = 5,
            backoff = @Backoff(delay = 1000 * 60 * 10))
    public void sendSimpleMessage(Email email) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getRecipients().toArray(new String[0]));
        message.setSubject(email.getSubject());
        message.setText(email.getMessageContext());

        javaMailSender.send(message);
    }
}