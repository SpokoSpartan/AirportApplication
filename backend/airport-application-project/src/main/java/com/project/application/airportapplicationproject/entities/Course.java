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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Setter
	private Date departureDate;
	
	@Setter 
	private Date arrivalDate;
	
	@Setter
	private Integer availablePlaces;

	@Setter
	@ManyToOne(	cascade= {	CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH},
				fetch=FetchType.LAZY)
	@JoinColumn(name="start_fk")
	private Airport startAirport;
	
	@Setter
	@ManyToOne(	cascade= {	CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH},
				fetch=FetchType.LAZY)
	@JoinColumn(name="end_fk")
	private Airport endAirport;
	
	@Setter
	@ManyToOne(	cascade= {	CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH},
				fetch=FetchType.LAZY)
	@JoinColumn(name="plane_fk")
	private Plane plane;
	
	@Setter
	@OneToMany(	cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	@JoinColumn(name="tick_pk")
	private List<Ticket> tickets;
}
