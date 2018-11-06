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
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
	}

	@Override
	public Ticket createTicket(TicketDTO ticketDTO) {
		ModelMapper mapper = new ModelMapper();
		Ticket ticket = mapper.map(ticketDTO, Ticket.class);
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Long id, TicketDTO ticketDTO) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
		ticket.setSaleDate(ticketDTO.getSaleDate());
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TicketService", "id", id));
		ticketRepository.delete(ticket);
	}
}
