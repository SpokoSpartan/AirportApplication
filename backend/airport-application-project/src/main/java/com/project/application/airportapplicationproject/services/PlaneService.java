package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;

public interface PlaneService {

	List<Plane> getAllPlanes();
	
	Plane getPlaneById(Long id);
	
	Plane createPlane(PlaneDTO planeDTO);
	
	Plane updatePlane(Long id, PlaneDTO planeDTO);
	
	void deletePlane(Long id);
}
