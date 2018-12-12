package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.AirportDTO;
import com.project.application.airportapplicationproject.services.AirportService;
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
@RequestMapping(Mappings.API_VERSION + Mappings.AIRPORT)
public class AirportController {

    private final AirportService airportService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllAirports(){
        return ResponseEntity.ok().body(new MessageInfo(airportService.getAllAirport(), true,
                Arrays.asList("List of airports")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MessageInfo(airportService.getAirportById(id), true,
                Arrays.asList("Airport of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createAirport(@RequestBody @Valid AirportDTO airportDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(airportService.createAirport(airportDTO), true,
                Arrays.asList("Airport created successfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updateAirport(@PathVariable Long id, @RequestBody @Valid AirportDTO airportDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(airportService.updateAirport(id, airportDTO), true,
                Arrays.asList("Airport with ID = " + id.toString() + " updated successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true, Arrays.asList("Airport with id = " + id.toString() + "removed succesfully")));
    }
}