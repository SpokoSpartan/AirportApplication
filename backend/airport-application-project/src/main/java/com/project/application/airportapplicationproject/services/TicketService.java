package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.TicketDTO;
import com.project.application.airportapplicationproject.entities.Ticket;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.TicketRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepository;
	
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
	}

	public MessageInfo createTicket(TicketDTO ticketDTO) {
		ModelMapper mapper = new ModelMapper();
		Ticket ticket = mapper.map(ticketDTO, Ticket.class);
		return saveTicket(ticket, "Ticket created successfully");
	}

	public MessageInfo updateTicket(Long id, TicketDTO ticketDTO) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
		ticket.setClient(ticketDTO.getClient());
		ticket.setCourse(ticketDTO.getCourse());
		return saveTicket(ticket, "Ticket with id = " + id.toString() + "created successfully");
	}

	public void deleteTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
		ticketRepository.delete(ticket);
	}

	private MessageInfo saveTicket(Ticket ticket, String defaultMessage){
		try {
			ticket = ticketRepository.save(ticket);
		}
		catch (ConstraintViolationException exc){
			return MessageInfo.getErrors(exc);
		}
		return new MessageInfo(ticket, true, Arrays.asList(defaultMessage));
	}
}
