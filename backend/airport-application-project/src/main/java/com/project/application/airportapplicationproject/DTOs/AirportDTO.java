package com.project.application.airportapplicationproject.DTOs;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {

	@NotEmpty(message = "City name can't be empty")
	private String city;

	@NotEmpty(message = "Airport name can't be empty")
	private String name;
}
