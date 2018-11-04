package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	Employee createEmployee(EmployeeDTO employeeDTO);
	
	Employee updateEmployee(Long id, EmployeeDTO employeeDTO);
	
	void deleteEmployee(Long id);
}
