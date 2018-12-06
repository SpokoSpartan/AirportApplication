package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
public class Course implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Please specify the departure date")
	@Future(message = "The departure date should be a future date")
	private Date departureDate;

	@NotNull(message = "Please specify the arrival date")
	@Future(message = "The departure date should be a future date")
	private Date arrivalDate;

	@NotNull(message = "Please specify the number of available places")
	private Integer availablePlaces;

	@NotNull(message = "Please specify the start airport")
	@ManyToOne(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="start_fk")
	private Airport startAirport;

	@NotNull(message = "Please specify the and airport")
	@ManyToOne(	cascade= {	CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="end_fk")
	private Airport endAirport;

	@NotNull(message = "Please specify the plane")
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

	@NotNull(message = "Please specify the allocations")
	@OneToMany( mappedBy = "course")
	private List<Allocation> allocations;
}
