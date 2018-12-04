package com.project.application.airportapplicationproject.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Allocation {
	
	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

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
