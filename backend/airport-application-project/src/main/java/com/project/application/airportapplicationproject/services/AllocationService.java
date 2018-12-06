package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.AllocationRepository;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.AllocationDTO;
import com.project.application.airportapplicationproject.entities.Allocation;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

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

	public MessageInfo createAllocation(AllocationDTO allocationDTO) {
		ModelMapper mapper = new ModelMapper();
		Allocation allocation = mapper.map(allocationDTO, Allocation.class);
		return saveAllocation(allocation, "Airport created successfully");
	}

	public MessageInfo updateAllocation(Long id, AllocationDTO allocationDTO) {
		Allocation allocation = allocationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("allocation"));
		allocation.setEmployee(allocationDTO.getEmployee());
		return saveAllocation(allocation, "Airport with ID = " + id.toString() + " created successfully");
	}

	public void deleteAllocation(Long id) {
		Allocation allocation = allocationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("allocation"));
		allocationRepository.delete(allocation);
	}

	private MessageInfo saveAllocation(Allocation allocation, String defaultMessage){
		try {
			allocation = allocationRepository.save(allocation);
		}
		catch (ConstraintViolationException exc){
			MessageInfo errors = MessageInfo.getErrors(exc);
			return errors;
		}
		return new MessageInfo(allocation, true, Arrays.asList(defaultMessage));
	}
}