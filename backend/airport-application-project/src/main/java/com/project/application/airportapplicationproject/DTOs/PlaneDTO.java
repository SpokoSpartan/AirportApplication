package com.project.application.airportapplicationproject.DTOs;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaneDTO {

	@NotNull(message = "Please specify the capacity")
	private Long capacity;

	@NotBlank(message = "Please specify the manufacturer")
	private String manufacturer;

	@NotBlank(message = "Please specify the version")
	private String version;

	@NotNull(message = "Please specify the number of pilots")
	private Long numberOfPilots;

	@NotNull(message = "Please specify the number of hostess")
	private Long numberOfHostess;
}
