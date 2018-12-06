package com.project.application.airportapplicationproject.services;

import java.util.Arrays;
import java.util.List;

import com.project.application.airportapplicationproject.utils.MessageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.application.airportapplicationproject.DTOs.PersonDTO;
import com.project.application.airportapplicationproject.entities.Person;
import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.PersonRepository;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;
	
	public List<Person> detAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("person"));
	}

	public MessageInfo createPerson(PersonDTO personDTO) {
		ModelMapper mapper = new ModelMapper();
		Person person = mapper.map(personDTO, Person.class);
		return savePerson(person, "Person created successfully");
	}

	public MessageInfo updatePerson(Long id, PersonDTO personDTO) {
		Person person = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pperson"));
		person.setCity(personDTO.getCity());
		person.setEmail(personDTO.getEmail());
		person.setIdCardNumber(personDTO.getIdCardNumber());
		person.setName(personDTO.getName());
		person.setPhoneNumber(personDTO.getPhoneNumber());
		person.setSurname(personDTO.getSurname());		
		return savePerson(person, "Person with ID = " + id.toString() + " created successfully");
	}

	public void deletePerson(Long id) {
		Person person = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("person"));
		personRepository.delete(person);
	}

	private MessageInfo savePerson(Person person, String defaultMessage){
		try {
			person = personRepository.save(person);
		}
		catch (ConstraintViolationException exc){
			return MessageInfo.getErrors(exc);
		}
		return new MessageInfo(person, true, Arrays.asList(defaultMessage));
	}
}
