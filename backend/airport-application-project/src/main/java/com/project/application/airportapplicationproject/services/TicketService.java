package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.DTOs.Email;
import com.project.application.airportapplicationproject.entities.Client;
import com.project.application.airportapplicationproject.entities.Course;
import com.project.application.airportapplicationproject.repositories.CourseRepository;
import com.project.application.airportapplicationproject.utils.EmailToClientTemplate;
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
	private final CourseRepository courseRepository;
	private final EmailService emailService;
	
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
	}

	public Ticket createTicket(TicketDTO ticketDTO) {
		Client client = ticketDTO.getClient();
		Course course = courseRepository.findById(ticketDTO.getCourseId()).orElseThrow( ()->
				new ResourceNotFoundException("course"));
		Ticket ticket = new Ticket();
		ticket.setCourse(course);
		ticket.setClient(client);
		ticket.setTravelClass(ticketDTO.getTravelClass());

		emailService.sendSimpleMessage(EmailToClientTemplate.getEmail(ticket),
				Arrays.asList(client.getPerson().getEmail()));

		return ticketRepository.save(ticket);
	}

	public Ticket updateTicket(Long id, TicketDTO ticketDTO) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
		Client client = ticketDTO.getClient();
		Course course = courseRepository.findById(ticketDTO.getCourseId()).orElseThrow( ()->
				new ResourceNotFoundException("course"));
		ticket.setCourse(course);
		ticket.setClient(client);
		ticket.setTravelClass(ticketDTO.getTravelClass());
		return ticketRepository.save(ticket);
	}

	public void deleteTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ticket"));
		ticketRepository.delete(ticket);
	}
}
