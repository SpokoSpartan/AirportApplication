package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.services.EmployeeService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(Mappings.GET_ALL)
    public MessageInfo getAllEmployees(){
        return new MessageInfo(employeeService.getAllEmployees(), true, Arrays.asList("List of employees"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getEmployeeById(@PathVariable Long id) {
        return new MessageInfo(employeeService.getEmployeeById(id), true, Arrays.asList("Employee of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return employeeService.createEmployee(employeeDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new MessageInfo(null, true, Arrays.asList("Employee with id = " + id.toString() + "removed succesfully"));
    }
}
