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
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EmploueeService", "id", id));
	}

	@Override
	public Employee createEmployee(EmployeeDTO employeeDTO) {
		ModelMapper mapper = new ModelMapper();
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EmploueeService", "id", id));
		employee.setFireDate(employeeDTO.getFireDate());
		employee.setHireDate(employeeDTO.getHireDate());
		employee.setSalary(employeeDTO.getSalary());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EmploueeService", "id", id));
		employeeRepository.delete(employee);
	}
}
