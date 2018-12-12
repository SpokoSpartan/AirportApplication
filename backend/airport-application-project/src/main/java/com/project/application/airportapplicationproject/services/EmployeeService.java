package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.entities.Employee;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee"));
	}

	public Employee createEmployee(EmployeeDTO employeeDTO) {
		ModelMapper mapper = new ModelMapper();
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee"));
		employee.setFireDate(employeeDTO.getFireDate());
		employee.setSalary(employeeDTO.getSalary());
		employee.setFunction(employeeDTO.getFunction());
		employee.setPerson(employeeDTO.getPerson());
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee"));
		employeeRepository.delete(employee);
	}
}