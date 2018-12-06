package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Entity
public class Function implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please specify the name of function")
	private String name;

	@NotNull(message = "Please specify the minimum salary")
	private BigDecimal minimumSalary;
}
