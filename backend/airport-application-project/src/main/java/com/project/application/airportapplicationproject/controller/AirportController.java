package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.AirportDTO;
import com.project.application.airportapplicationproject.services.AirportService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
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
    public MessageInfo getAllAirports(){
        return new MessageInfo(airportService.getAllAirport(), true, Arrays.asList("List of airports"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getAirportById(@PathVariable Long id) {
        return new MessageInfo(airportService.getAirportById(id), true, Arrays.asList("Airport of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createAirport(@RequestBody @Valid AirportDTO airportDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return airportService.createAirport(airportDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updateAirport(@PathVariable Long id, @RequestBody @Valid AirportDTO airportDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return airportService.updateAirport(id, airportDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return new MessageInfo(null, true, Arrays.asList("Airport with id = " + id.toString() + "removed succesfully"));
    }
}