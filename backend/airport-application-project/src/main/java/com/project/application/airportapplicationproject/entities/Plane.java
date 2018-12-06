package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

import java.io.Serializable;

@Entity
@Data
public class Plane implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Please specify the capacity")
	private Long capacity;

	@NotBlank(message = "Please specify the manufacturer")
	private String manufacturer;

	@NotBlank(message = "Please specify the version")
	private String version;

	@NotNull(message = "Please specify the number of pilots")
	private Long numberOfPilots;

	@NotNull(message = "Please specify the number of hostess")
	private Long numberOfHostess;
}
