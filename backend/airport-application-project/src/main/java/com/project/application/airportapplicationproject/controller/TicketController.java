package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.TicketDTO;
import com.project.application.airportapplicationproject.services.TicketService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
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
    public MessageInfo getAllTickets(){
        return new MessageInfo(ticketService.getAllTickets(), true, Arrays.asList("List of tickets"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getTicketById(@PathVariable Long id) {
        return new MessageInfo(ticketService.getTicketById(id), true, Arrays.asList("Ticket of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createTicket(@RequestBody @Valid TicketDTO ticketDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return ticketService.createTicket(ticketDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updateTicket(@PathVariable Long id, @RequestBody @Valid TicketDTO ticketDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return ticketService.updateTicket(id, ticketDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new MessageInfo(null, true, Arrays.asList("Ticket with id = " + id.toString() + "removed succesfully"));
    }
}
