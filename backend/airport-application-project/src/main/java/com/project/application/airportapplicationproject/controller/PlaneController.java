package com.project.application.airportapplicationproject.controller;

import java.util.List;

import com.project.application.airportapplicationproject.services.PlaneService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.airportapplicationproject.DTOs.PlaneDTO;
import com.project.application.airportapplicationproject.entities.Plane;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class PlaneController {

	private final PlaneService planeService;
	
	@GetMapping("/planes")
	public List<Plane> getAllPlane() {
		return planeService.getAllPlanes();
	}

	@GetMapping("/planes/{id}")
	public Plane getPlaneById(@PathVariable Long id) {
		return planeService.getPlaneById(id);
	}

	@PostMapping("/planes")
	public Plane createPlane(@RequestBody PlaneDTO planeDTO) {
		return planeService.createPlane(planeDTO);
	}

	@PostMapping("/planes/{id}")
	public Plane updatePlane(@PathVariable Long id, @RequestBody PlaneDTO planeDTO){
		return planeService.updatePlane(id, planeDTO);
	}

	@DeleteMapping("/planes/{id}")
	public void deleteBook(@PathVariable Long id) throws ResourceNotFoundException {
		planeService.deletePlane(id);
	}
}
