package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.TicketDTO;
import com.project.application.airportapplicationproject.services.TicketService;
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
@RequestMapping(Mappings.API_VERSION + Mappings.TICKET)
public class TicketController {

    private final TicketService ticketService;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity getAllTickets(){
        return ResponseEntity.ok().body(new MessageInfo(ticketService.getAllTickets(), true, Arrays.asList("List of tickets")));
    }

    @GetMapping(Mappings.GET_ONE)
    public ResponseEntity getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MessageInfo(ticketService.getTicketById(id), true, Arrays.asList("Ticket of ID = " + id.toString())));
    }

    @PostMapping(Mappings.CREATE)
    public ResponseEntity createTicket(@RequestBody @Valid TicketDTO ticketDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(ticketService.createTicket(ticketDTO), true, Arrays.asList("Ticket created successfully")));
    }

    @PostMapping(Mappings.UPDATE)
    public ResponseEntity updateTicket(@PathVariable Long id, @RequestBody @Valid TicketDTO ticketDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return ResponseEntity.badRequest().body(errors);
        return ResponseEntity.ok().body(new MessageInfo(ticketService.updateTicket(id, ticketDTO), true, Arrays.asList("Ticket with id = " + id.toString() + "created successfully")));
    }

    @DeleteMapping(Mappings.REMOVE)
    public ResponseEntity deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().body(new MessageInfo(null, true, Arrays.asList("Ticket with id = " + id.toString() + "removed succesfully")));
    }
}
