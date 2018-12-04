package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.AirportDTO;
import com.project.application.airportapplicationproject.entities.Airport;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.AirportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportService {

	private final AirportRepository airportRepository;
	
	public List<Airport> getAllAirport() {
		return airportRepository.findAll();
	}

	public Airport getAirportById(Long id) {
		return airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AirportService", "id", id));
	}

	public Airport createAirport(AirportDTO airportDTO) {
		ModelMapper mapper = new ModelMapper();
		Airport airport = mapper.map(airportDTO, Airport.class);
		return airportRepository.save(airport);
	}

	public Airport updateAirport(Long id, AirportDTO airportDTO) {
		Airport airport = airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AirportService", "id", id));
		airport.setCity(airportDTO.getCity());
		airport.setName(airportDTO.getName());
		return airportRepository.save(airport);
	}

	public void deleteAirport(Long id) {
		Airport airport = airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AirportService", "id", id));
		airportRepository.delete(airport);
	}
}
