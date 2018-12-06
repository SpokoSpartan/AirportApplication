package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.FunctionDTO;
import com.project.application.airportapplicationproject.entities.Function;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.FunctionRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

@Service
@RequiredArgsConstructor
public class FunctionService {

	private final FunctionRepository functionRepository;

	public List<Function> getAllFunctions() {
		return functionRepository.findAll();
	}

	public Function getFunctionById(Long id) {
		return functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("function"));
	}

	public MessageInfo createFunction(FunctionDTO functionDTO) {
		ModelMapper mapper = new ModelMapper();
		Function function = mapper.map(functionDTO, Function.class);
		return saveFunction(function, "Function created successfully");
	}

	public MessageInfo updateFunction(Long id, FunctionDTO functionDTO) {
		Function function = functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("function"));
		function.setName(functionDTO.getName());
		function.setMinimumSalary(functionDTO.getMinimumSalary());
		return saveFunction(function, "Function with ID = " + id.toString() + " updated successfully");
	}

	public void deleteFunction(Long id) {
		Function function = functionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("function"));
		functionRepository.delete(function);
	}

	private MessageInfo saveFunction(Function function, String defaultMessage){
		try {
			function = functionRepository.save(function);
		}
		catch (ConstraintViolationException exc){
			return MessageInfo.getErrors(exc);
		}
		return new MessageInfo(function, true, Arrays.asList(defaultMessage));
	}
}
