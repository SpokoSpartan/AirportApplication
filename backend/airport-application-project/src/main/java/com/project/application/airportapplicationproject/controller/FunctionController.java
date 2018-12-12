package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.FunctionDTO;
import com.project.application.airportapplicationproject.services.FunctionService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.FUNCTION)
public class FunctionController {

    private final FunctionService functionService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllFunctions(){
        return ResponseEntity.ok().body(new MessageInfo(functionService.getAllFunctions(), true,
                Arrays.asList("List of functions")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getFunctionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MessageInfo(functionService.getFunctionById(id), true,
                Arrays.asList("Function of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createFunction(@RequestBody @Valid FunctionDTO functionDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(functionService.createFunction(functionDTO), true,
                Arrays.asList("Function created successfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updateFunction(@PathVariable Long id, @RequestBody @Valid FunctionDTO functionDTO,
                                      BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(functionService.updateFunction(id, functionDTO), true,
                Arrays.asList("Function with ID = " + id.toString() + " updated successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deleteFunction(@PathVariable Long id) {
        functionService.deleteFunction(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true,
                Arrays.asList("Function with id = " + id.toString() + "removed succesfully")));
    }
}
