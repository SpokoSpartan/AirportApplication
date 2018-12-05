package com.project.application.airportapplicationproject.DTOs;

import java.math.BigDecimal;
import java.util.Date;

import com.project.application.airportapplicationproject.entities.Function;
import com.project.application.airportapplicationproject.entities.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private Date fireDate;

	@NotNull(message = "Please specify the salary")
	private BigDecimal salary;

	@NotNull(message = "Please specify the person")
	private Person person;

	@NotNull(message = "Please specify the function")
	private Function function;
}