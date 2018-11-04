package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.TicketDTO;
import com.project.application.airportapplicationproject.entities.Ticket;

public interface TicketService {
	
	List<Ticket> getAllTickets();
	
	Ticket getTicketById(Long id);
	
	Ticket createTicket(TicketDTO ticketDTO);
	
	Ticket updateTicket(Long id, TicketDTO ticketDTO);
	
	void deleteTicket(Long id);
}
