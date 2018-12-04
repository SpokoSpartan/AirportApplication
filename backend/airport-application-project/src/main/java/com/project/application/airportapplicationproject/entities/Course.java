package com.project.application.airportapplicationproject.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@Data
public class Course {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private Date departureDate;
	
	private Date arrivalDate;
	
	private Integer availablePlaces;

	@ManyToOne(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="start_fk")
	private Airport startAirport;
	
	@ManyToOne(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="end_fk")
	private Airport endAirport;
	
	@ManyToOne(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="plane_fk")
	private Plane plane;
	
	@OneToMany(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="tick_pk")
	private List<Ticket> tickets;
}
