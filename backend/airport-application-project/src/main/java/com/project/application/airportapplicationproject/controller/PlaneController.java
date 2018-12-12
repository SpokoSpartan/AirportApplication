package com.project.application.airportapplicationproject.controller;

import java.util.Arrays;

import com.project.application.airportapplicationproject.services.PlaneService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.PLANE)
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllPlanes(){
        return ResponseEntity.ok().body(new MessageInfo(planeService.getAllPlanes(), true,
                Arrays.asList("List of planes")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getPlaneById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MessageInfo(planeService.getPlaneById(id), true,
                Arrays.asList("Plane of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createPlane(@RequestBody @Valid PlaneDTO employeeDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(planeService.createPlane(employeeDTO), true,
                Arrays.asList("Plane created successfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updatePlane(@PathVariable Long id, @RequestBody @Valid PlaneDTO planeDTO,
                                      BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(planeService.updatePlane(id, planeDTO), true,
                Arrays.asList("Plane with ID = " + id.toString() + " created successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true,
                Arrays.asList("Plane with id = " + id.toString() + "removed succesfully")));
    }
}