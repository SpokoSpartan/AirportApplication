package com.project.application.airportapplicationproject.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Worker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Setter
	private Date hireDate;

	@Setter
	private Date fireDate;
	
	@Setter
	private BigDecimal salary;
	
	// FK person id
	
	// FK function id
}
