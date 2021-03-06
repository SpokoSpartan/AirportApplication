package com.project.application.airportapplicationproject.services;

import java.util.List;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.PlaneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaneService {

	private final PlaneRepository planeRepository;

	Logger logger = Logger.getLogger(getClass().getName());

	public List<Plane> getAllPlanes() {
		return planeRepository.findAll();
	}

	public Plane getPlaneById(Long id) {
		return planeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("plane"));
	}

	public Plane createPlane(PlaneDTO planeDTO) {
		ModelMapper mapper = new ModelMapper();
		Plane plane = mapper.map(planeDTO, Plane.class);
		return planeRepository.save(plane);
	}

	public Plane updatePlane(Long id, PlaneDTO planeDTO) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("plane"));
		plane.setCapacity(planeDTO.getCapacity());
		plane.setManufacturer(planeDTO.getManufacturer());
		plane.setVersion(planeDTO.getVersion());
		plane.setNumberOfHostess(planeDTO.getNumberOfHostess());
		plane.setNumberOfPilots(planeDTO.getNumberOfPilots());
		return planeRepository.save(plane);
	}

	public void deletePlane(Long id) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("plane"));
		planeRepository.delete(plane);
	}
}
