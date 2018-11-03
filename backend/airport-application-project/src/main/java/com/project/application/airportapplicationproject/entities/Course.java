package com.project.application.airportapplicationproject.entities;

import java.util.Date;

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
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Setter
	private Date departureDate;
	
	@Setter 
	private Date arrivalDate;
	
	@Setter
	private Integer availablePlaces;

	// FK start Id (airport)
	
	// FK end id (airport)
	
	// FK plane id
}
