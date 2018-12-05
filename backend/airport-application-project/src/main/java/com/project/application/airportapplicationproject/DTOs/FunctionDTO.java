package com.project.application.airportapplicationproject.DTOs;

import java.math.BigDecimal;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionDTO {

	@NotBlank(message = "Please specify the name of function")
	private String name;

	@NotBlank(message = "Please specify the minimum salary")
	private BigDecimal minimumSalary;

}
