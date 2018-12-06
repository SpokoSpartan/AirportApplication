package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.entities.Employee;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

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

	public MessageInfo createEmployee(EmployeeDTO employeeDTO) {
		ModelMapper mapper = new ModelMapper();
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return saveEmployee(employee, "Employee created succesfully");
	}

	public MessageInfo updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee"));
		employee.setFireDate(employeeDTO.getFireDate());
		employee.setSalary(employeeDTO.getSalary());
		employee.setFunction(employeeDTO.getFunction());
		employee.setPerson(employeeDTO.getPerson());
		return saveEmployee(employee, "Employee with ID = " + id.toString() + "updated successfully");
	}

	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee"));
		employeeRepository.delete(employee);
	}

	private MessageInfo saveEmployee(Employee employee, String defaultMessage){
		try {
			employee = employeeRepository.save(employee);
		}
		catch (ConstraintViolationException exc){
			return MessageInfo.getErrors(exc);
		}
		return new MessageInfo(employee, true, Arrays.asList(defaultMessage));
	}
}