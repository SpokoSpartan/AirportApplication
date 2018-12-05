package com.project.application.airportapplicationproject.DTOs;

import java.util.Date;
import java.util.List;

import com.project.application.airportapplicationproject.entities.Airport;
import com.project.application.airportapplicationproject.entities.Allocation;
import com.project.application.airportapplicationproject.entities.Plane;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

	@NotNull(message = "Please specify the departure date")
	@Future(message = "The departure date should be a future date")
	private Date departureDate;

	@NotNull(message = "Please specify the arrival date")
	@Future(message = "The departure date should be a future date")
	private Date arrivalDate;

	@NotNull(message = "Please specify the number of available places")
	private Integer availablePlaces;

	@NotNull(message = "Please specify the plane")
	private Plane plane;

	@NotNull(message = "Please specify the start airport")
	private Airport startAirport;

	@NotNull(message = "Please specify the and airport")
	private Airport endAirport;

	@NotNull(message = "Please specify the allocations")
	private List<Allocation> allocations;
}
