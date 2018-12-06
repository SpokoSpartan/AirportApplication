package com.project.application.airportapplicationproject.controller;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.services.PlaneService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.PLANE)
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping(Mappings.GET_ALL)
    public MessageInfo getAllPlanes(){
        return new MessageInfo(planeService.getAllPlanes(), true, Arrays.asList("List of planes"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getPlaneById(@PathVariable Long id) {
        return new MessageInfo(planeService.getPlaneById(id), true, Arrays.asList("Plane of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createPlane(@RequestBody @Valid PlaneDTO employeeDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return planeService.createPlane(employeeDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updatePlane(@PathVariable Long id, @RequestBody @Valid PlaneDTO planeDTO,
                                      BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return planeService.updatePlane(id, planeDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return new MessageInfo(null, true, Arrays.asList("Plane with id = " + id.toString() + "removed succesfully"));
    }
}
