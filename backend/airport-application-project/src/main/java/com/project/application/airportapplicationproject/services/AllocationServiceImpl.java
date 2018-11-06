package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.AllocationDTO;
import com.project.application.airportapplicationproject.entities.Allocation;

import lombok.RequiredArgsConstructor;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	@Override
	public List<Allocation> getAllAllocations() {
		return null;
	}

	@Override
	public Allocation getAllocationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation createAllocation(AllocationDTO allocationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation updateAllocation(Long id, AllocationDTO allocationDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllocation(Long id) {
		// TODO Auto-generated method stub

	}
}
