package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.AirportDTO;
import com.project.application.airportapplicationproject.entities.Airport;

public interface AirportService {

	List<Airport> getAllAirport();
	
	Airport getAirportById(Long id);
	
	Airport createAirport(AirportDTO airportDTO);
	
	Airport updateAirport(Long id, AirportDTO airportDTO);
	
	void deleteAirport(Long id);
}
