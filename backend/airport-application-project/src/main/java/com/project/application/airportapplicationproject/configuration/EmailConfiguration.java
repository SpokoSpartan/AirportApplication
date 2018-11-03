package com.project.application.airportapplicationproject.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@ComponentScan(basePackages="com.project.application.airportapplicationproject")
@PropertySource("classpath:application.yml")
@RequiredArgsConstructor
public class EmailConfiguration {

    private Environment env;
    
	@Bean
    public JavaMailSender getJavaMailSender() {
        
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
        
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", env.getProperty("spring.mail.properties.mail.transport.protocol"));
        props.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
        props.put("mail.debug", "true");
        
        return mailSender;
    }
}
