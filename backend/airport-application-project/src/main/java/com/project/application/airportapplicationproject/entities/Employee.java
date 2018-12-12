package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	private Date hireDate;

	private Date fireDate;

	@NotBlank(message = "Please specify the password")
	@Size(min = 7 , message = "Password should contain at least 7 characters length")
	private String password;

	@NotNull(message = "Please specify the salary")
	private BigDecimal salary;

	@NotNull(message = "Please specify the person")
	@OneToOne(	cascade = { CascadeType.PERSIST,
				CascadeType.MERGE,
				CascadeType.REMOVE},
				fetch=FetchType.LAZY)
	@JoinColumn(name="person_fk")
	private Person person;

	@NotNull(message = "Please specify the function")
	@ManyToOne(cascade = { CascadeType.PERSIST,
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
