package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.AllocationDTO;
import com.project.application.airportapplicationproject.entities.Allocation;

public interface AllocationService {

	List<Allocation> getAllAllocations();
	
	Allocation getAllocationById(Long id);
	
	Allocation createAllocation(AllocationDTO allocationDTO);
	
	Allocation updateAllocation(Long id, AllocationDTO allocationDTO);
	
	void deleteAllocation(Long id);
}
