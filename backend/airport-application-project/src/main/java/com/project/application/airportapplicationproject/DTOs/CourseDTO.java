package com.project.application.airportapplicationproject.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

	private Date departureDate;
	private Date arrivalDate;
	private Integer availablePlaces;
}
