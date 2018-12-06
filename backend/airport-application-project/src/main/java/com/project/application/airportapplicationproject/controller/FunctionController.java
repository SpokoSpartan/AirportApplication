package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.FunctionDTO;
import com.project.application.airportapplicationproject.services.FunctionService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
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
    public MessageInfo getAllFunctions(){
        return new MessageInfo(functionService.getAllFunctions(), true, Arrays.asList("List of functions"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getFunctionById(@PathVariable Long id) {
        return new MessageInfo(functionService.getFunctionById(id), true, Arrays.asList("Function of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createFunction(@RequestBody @Valid FunctionDTO functionDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return functionService.createFunction(functionDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updateFunction(@PathVariable Long id, @RequestBody @Valid FunctionDTO functionDTO,
                                      BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return functionService.updateFunction(id, functionDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deleteFunction(@PathVariable Long id) {
        functionService.deleteFunction(id);
        return new MessageInfo(null, true, Arrays.asList("Function with id = " + id.toString() + "removed succesfully"));
    }
}
