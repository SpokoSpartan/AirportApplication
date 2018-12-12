package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.Email;
import com.project.application.airportapplicationproject.services.EmailService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.EMAIL)
public class EmailController {

    private final EmailService emailService;

    @PostMapping(Mappings.CREATE)
    public ResponseEntity sendEmail(@RequestBody @Valid Email email, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if (errors != null) return ResponseEntity.badRequest().body(errors);
        emailService.sendSimpleMessage(email, Arrays.asList("wojtekspoton@gmail.com"));
        return ResponseEntity.ok().body(new MessageInfo(null, true, Arrays.asList("Email sent successfully")));
    }
}