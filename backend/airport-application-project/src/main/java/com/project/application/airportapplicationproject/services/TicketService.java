package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.TicketDTO;
import com.project.application.airportapplicationproject.entities.Ticket;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepository;
	
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
	}

	public Ticket createTicket(TicketDTO ticketDTO) {
		ModelMapper mapper = new ModelMapper();
		Ticket ticket = mapper.map(ticketDTO, Ticket.class);
		return ticketRepository.save(ticket);
	}

	public Ticket updateTicket(Long id, TicketDTO ticketDTO) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
		return ticketRepository.save(ticket);
	}

	public void deleteTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
		ticketRepository.delete(ticket);
	}
}
