package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
public class Plane {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long capacity;
	
	private String manufacturer;
	
	private String version;
	
	private Long numberOfPilots;
	
	private Long numberOfHostess;
}
