package com.project.application.airportapplicationproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Allocation implements Serializable {
	
	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Please specify the employee")
	@OneToOne(	cascade = { CascadeType.MERGE,
						  	CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne( cascade = {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
}
