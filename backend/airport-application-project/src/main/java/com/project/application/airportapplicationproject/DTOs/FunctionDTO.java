package com.project.application.airportapplicationproject.DTOs;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FunctionDTO {

	private String name;
	private BigDecimal minimumSalary;

}
