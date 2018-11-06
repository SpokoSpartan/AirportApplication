package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.PlaneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService{

	private final PlaneRepository planeRepository;
	
	@Override
	public List<Plane> getAllPlanes() {
		return planeRepository.findAll();
	}

	@Override
	public Plane getPlaneById(Long id) {
		return planeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PlaneRepository", "id", id));
	}

	@Override
	public Plane createPlane(PlaneDTO planeDTO) {
		ModelMapper mapper = new ModelMapper();
		Plane plane = mapper.map(planeDTO, Plane.class);
		return planeRepository.save(plane);
	}

	@Override
	public Plane updatePlane(Long id, PlaneDTO planeDTO) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PlaneRepository", "id", id));
		plane.setCapacity(planeDTO.getCapacity());
		plane.setManufacturer(planeDTO.getManufacturer());
		plane.setVersion(planeDTO.getVersion());
		plane.setNumberOfHostess(planeDTO.getNumberOfHostess());
		plane.setNumberOfPilots(planeDTO.getNumberOfPilots());
		return planeRepository.save(plane);
	}

	@Override
	public void deletePlane(Long id) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PlaneRepository", "id", id));
		planeRepository.delete(plane);
	}
}
