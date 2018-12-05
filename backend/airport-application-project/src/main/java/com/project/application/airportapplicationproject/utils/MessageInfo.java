package com.project.application.airportapplicationproject.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class MessageInfo {

    private Object object;
    private Boolean success;
    private List<String> message;

    public static MessageInfo getErrors(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<String> errorsList = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return new MessageInfo(null, false, errorsList);
        }
        return null;
    }
}
