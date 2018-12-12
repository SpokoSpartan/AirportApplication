package com.project.application.airportapplicationproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
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
