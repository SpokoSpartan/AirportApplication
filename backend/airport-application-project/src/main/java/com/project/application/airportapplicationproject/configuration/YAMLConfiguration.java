package com.project.application.airportapplicationproject.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Setter
@Getter
public class YAMLConfiguration {
    
    private String emailUsername;
    private String emailPassword;   
}