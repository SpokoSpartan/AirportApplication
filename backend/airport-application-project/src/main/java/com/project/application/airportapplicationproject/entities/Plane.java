package com.project.application.airportapplicationproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
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
