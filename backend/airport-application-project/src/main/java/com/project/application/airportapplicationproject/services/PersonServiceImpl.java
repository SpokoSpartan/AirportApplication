package com.project.application.airportapplicationproject.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.PersonDTO;
import com.project.application.airportapplicationproject.entities.Person;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	
	@Override
	public List<Person> detAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PersonService", "id", id));
	}

	@Override
	public Person createPerson(PersonDTO personDTO) {
		ModelMapper mapper = new ModelMapper();
		Person person = mapper.map(personDTO, Person.class);
		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(Long id, PersonDTO personDTO) {
		Person person = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PersonService", "id", id));
		person.setCity(personDTO.getCity());
		person.setEmail(personDTO.getEmail());
		person.setIdCardNumber(personDTO.getIdCardNumber());
		person.setName(personDTO.getName());
		person.setPhoneNumber(personDTO.getPhoneNumber());
		person.setSurname(personDTO.getSurname());		
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Long id) {
		Person person = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PersonService", "id", id));
		personRepository.delete(person);
	}
}
