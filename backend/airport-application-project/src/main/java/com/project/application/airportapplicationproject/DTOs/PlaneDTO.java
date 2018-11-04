package com.project.application.airportapplicationproject.DTOs;

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
public class PlaneDTO {

	private Long capacity;
	private String manufacturer;
	private String version;
	private Long numberOfPilots;
	private Long numberOfHostess;
}
