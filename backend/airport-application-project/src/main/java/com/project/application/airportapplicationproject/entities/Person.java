package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Setter
	private String name;
	
	@Setter
	private String surname;
	
	@Setter
	private String idCardNumber;
	
	@Setter 
	private String city;

	@Setter
	private String email;
	
	@Setter 
	private String phoneNumber;
}
