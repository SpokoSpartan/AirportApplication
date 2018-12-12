package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.services.EmployeeService;
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
@RequestMapping(Mappings.API_VERSION + Mappings.EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllEmployees(){
        return ResponseEntity.ok().body(new MessageInfo(employeeService.getAllEmployees(), true,
                Arrays.asList("List of employees")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MessageInfo(employeeService.getEmployeeById(id), true,
                Arrays.asList("Employee of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(employeeService.createEmployee(employeeDTO), true,
                Arrays.asList("Employee created succesfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(employeeService.updateEmployee(id, employeeDTO), true,
                Arrays.asList("Employee with ID = " + id.toString() + "updated successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true,
                Arrays.asList("Employee with id = " + id.toString() + "removed succesfully")));
    }
}
