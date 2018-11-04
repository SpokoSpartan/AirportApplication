package com.project.application.airportapplicationproject.services;

import java.util.List;

import com.project.application.airportapplicationproject.DTOs.PersonDTO;
import com.project.application.airportapplicationproject.entities.Person;

public interface PersonService {

	List<Person> detAllPersons();
	
	Person getPersonById(Long id);
	
	Person createPerson(PersonDTO personDTO);
	
	Person updatePerson(Long id, PersonDTO personDTO);
	
	void deletePerson(Long id);
}
