package com.project.application.airportapplicationproject.DTOs;

import com.project.application.airportapplicationproject.entities.Client;
import com.project.application.airportapplicationproject.entities.Course;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

	@Valid
	@NotNull(message = "Please specify the course")
	private Course course;

	@Valid
	@NotNull(message = "Please specify the client")
	private Client client;
}
