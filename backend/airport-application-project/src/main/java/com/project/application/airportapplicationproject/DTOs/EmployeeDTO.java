package com.project.application.airportapplicationproject.DTOs;

import java.math.BigDecimal;
import java.util.Date;

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
public class EmployeeDTO {

	private Date hireDate;
	private Date fireDate;
	private BigDecimal salary;
}