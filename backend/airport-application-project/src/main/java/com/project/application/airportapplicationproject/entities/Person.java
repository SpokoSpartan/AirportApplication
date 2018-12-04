package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
public class Person {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String idCardNumber;
	
	private String city;

	private String email;
	
	private String phoneNumber;
}
