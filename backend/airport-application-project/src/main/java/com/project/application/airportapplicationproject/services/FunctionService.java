package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.FunctionDTO;
import com.project.application.airportapplicationproject.entities.Function;

public interface FunctionService {

	List<Function> getAllFunctions();
	
	Function getFunctionById(Long id);
	
	Function createFunction(FunctionDTO functionDTO);
	
	Function updateFunction(Long id, FunctionDTO functionDTO);
	
	void deleteFunction(Long id);
}