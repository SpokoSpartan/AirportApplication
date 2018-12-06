package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.PlaneRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

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

	public MessageInfo createPlane(PlaneDTO planeDTO) {
		ModelMapper mapper = new ModelMapper();
		Plane plane = mapper.map(planeDTO, Plane.class);
		return savePlane(plane , "Plane created successfully");
	}

	public MessageInfo updatePlane(Long id, PlaneDTO planeDTO) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("plane"));
		plane.setCapacity(planeDTO.getCapacity());
		plane.setManufacturer(planeDTO.getManufacturer());
		plane.setVersion(planeDTO.getVersion());
		plane.setNumberOfHostess(planeDTO.getNumberOfHostess());
		plane.setNumberOfPilots(planeDTO.getNumberOfPilots());
		return savePlane(plane, "Plane with ID = " + id.toString() + " created successfully");
	}

	public void deletePlane(Long id) {
		Plane plane = planeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("plane"));
		planeRepository.delete(plane);
	}

	private MessageInfo savePlane(Plane plane, String defaultMessage){
		try {
			plane = planeRepository.save(plane);
		}
		catch (ConstraintViolationException exc){
			return MessageInfo.getErrors(exc);
		}
		return new MessageInfo(plane, true, Arrays.asList(defaultMessage));
	}
}
