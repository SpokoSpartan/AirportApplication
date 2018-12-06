package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import java.io.Serializable;

@Entity
@Data
public class Airport implements Serializable {
	
	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "City name can't be empty")
	private String city;

	@NotEmpty(message = "Airport name can't be empty")
	private String name;
}
