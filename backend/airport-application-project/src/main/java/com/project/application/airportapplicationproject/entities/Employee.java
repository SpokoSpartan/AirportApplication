package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Setter
	private Date hireDate;

	@Setter
	private Date fireDate;
	
	@Setter
	private BigDecimal salary;
	
	@Setter
	@OneToOne(	cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	@JoinColumn(name="person_fk")
	private Person person;
	
	@Setter
	@ManyToOne(	cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	@JoinColumn(name="function_fk")
	private Function function;	
}
