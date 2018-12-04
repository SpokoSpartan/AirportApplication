package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Entity
@Data
public class Employee implements Serializable{

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private Date hireDate;

	private Date fireDate;

	private String password;

	private BigDecimal salary;

	@OneToOne(	cascade = { CascadeType.PERSIST,
				CascadeType.MERGE,
				CascadeType.REMOVE},
				fetch=FetchType.LAZY)
	@JoinColumn(name="person_fk")
	private Person person;

	@ManyToOne(	cascade = { CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REMOVE},
			fetch=FetchType.LAZY)
	@JoinColumn(name="function_fk")
	private Function function;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {	CascadeType.DETACH,
					CascadeType.MERGE  })
	@JoinTable(name = "employee_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Role> roles;
}
