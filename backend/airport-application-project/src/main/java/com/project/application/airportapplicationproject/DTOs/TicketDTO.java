package com.project.application.airportapplicationproject.DTOs;

import com.project.application.airportapplicationproject.entities.Client;
import com.project.application.airportapplicationproject.entities.Course;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

	@NotNull(message = "Please specify the course")
	private Course course;

	@NotNull(message = "Please specify the client")
	private Client client;
}
