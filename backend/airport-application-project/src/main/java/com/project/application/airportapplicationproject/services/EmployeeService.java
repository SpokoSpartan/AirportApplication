package com.project.application.airportapplicationproject.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.project.application.airportapplicationproject.entities.Person;
import com.project.application.airportapplicationproject.entities.Role;
import com.project.application.airportapplicationproject.repositories.PersonRepository;
import com.project.application.airportapplicationproject.repositories.RoleRepository;
import org.dom4j.io.ElementModifier;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.EmployeeDTO;
import com.project.application.airportapplicationproject.entities.Employee;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {

	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final PersonRepository personRepository;

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

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Logger logger = Logger.getLogger(getClass().getName());
		logger.info("Jestem");

		List<Person> users = personRepository.findUsersByEmail(username);
		Person user = users != null ? users.get(0) : null;
		Employee employee = null;

		logger.info("Jestem + " + user);

		if(user != null) {
			 employee = employeeRepository.findEmployeeByPersonId(user.getId());
			logger.info("Jestem + " + employee);
		}
		return buildUserForAuthentication(employee, buildUserAuthority(employee.getRoles()));
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(Employee user, List<GrantedAuthority> authorities){
		return new org.springframework.security.core.userdetails.User(user.getPerson().getEmail(), user.getPassword(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for(Role role: roles){
			authorities.add( new SimpleGrantedAuthority(role.getRole()));
		}
		List<GrantedAuthority> result = new ArrayList<>(authorities);
		return result;
	}
}