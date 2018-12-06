package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.AirportDTO;
import com.project.application.airportapplicationproject.entities.Airport;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.AirportRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

@Service
@RequiredArgsConstructor
public class AirportService {

	private final AirportRepository airportRepository;
	
	public List<Airport> getAllAirport() {
		return airportRepository.findAll();
	}

	public Airport getAirportById(Long id) {
		return airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("airport"));
	}

	public MessageInfo createAirport(AirportDTO airportDTO) {
		ModelMapper mapper = new ModelMapper();
		Airport airport = mapper.map(airportDTO, Airport.class);
		return saveAirport(airport, "Airport created successfully");
	}

	public MessageInfo updateAirport(Long id, AirportDTO airportDTO) {
		Airport airport = airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("airport"));
		airport.setCity(airportDTO.getCity());
		airport.setName(airportDTO.getName());
		return saveAirport(airport, "Airport with ID = " + id.toString() + " updated successfully");
	}

	public void deleteAirport(Long id) {
		Airport airport = airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("airport"));
		airportRepository.delete(airport);
	}

	private MessageInfo saveAirport(Airport airport, String defaultMessage){
		try {
			airport = airportRepository.save(airport);
		}
		catch (ConstraintViolationException exc){
			MessageInfo errors = MessageInfo.getErrors(exc);

			airportRepository.delete(airport);

			return errors;
		}
		return new MessageInfo(airport, true, Arrays.asList(defaultMessage));
	}
}
