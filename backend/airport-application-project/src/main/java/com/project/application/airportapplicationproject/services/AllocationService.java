package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.AllocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.AllocationDTO;
import com.project.application.airportapplicationproject.entities.Allocation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public List<Allocation> getAllAllocations() {
		return null;
	}

	public Allocation getAllocationById(Long id) {
		return allocationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("allocation"));
	}

	public Allocation createAllocation(AllocationDTO allocationDTO) {
		ModelMapper mapper = new ModelMapper();
		Allocation allocation = mapper.map(allocationDTO, Allocation.class);
		return allocationRepository.save(allocation);
	}

	public Allocation updateAllocation(Long id, AllocationDTO allocationDTO) {
		Allocation allocation = allocationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("allocation"));
		allocation.setEmployee(allocationDTO.getEmployee());
		return allocationRepository.save(allocation);
	}

	public void deleteAllocation(Long id) {
		Allocation allocation = allocationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("allocation"));
		allocationRepository.delete(allocation);
	}
}