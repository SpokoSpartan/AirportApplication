package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.FunctionDTO;
import com.project.application.airportapplicationproject.entities.Function;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.FunctionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FunctionServiceImpl implements FunctionService {

	private final FunctionRepository functionRepository;
	
	@Override
	public List<Function> getAllFunctions() {
		return functionRepository.findAll();
	}

	@Override
	public Function getFunctionById(Long id) {
		return functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("FunctionService", "id", id));
	}

	@Override
	public Function createFunction(FunctionDTO functionDTO) {
		ModelMapper mapper = new ModelMapper();
		Function function = mapper.map(functionDTO, Function.class);
		return functionRepository.save(function);
	}

	@Override
	public Function updateFunction(Long id, FunctionDTO functionDTO) {
		Function function = functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("FunctionService", "id", id));
		function.setName(functionDTO.getName());
		function.setMinimumSalary(functionDTO.getMinimumSalary());
		return functionRepository.save(function);
	}

	@Override
	public void deleteFunction(Long id) {
		Function function = functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("FunctionService", "id", id));
		functionRepository.delete(function);
	}
}
