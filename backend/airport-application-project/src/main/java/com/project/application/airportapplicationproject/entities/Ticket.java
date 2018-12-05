package com.project.application.airportapplicationproject.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
public class Ticket {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@CreationTimestamp
	private Date saleDate;

	@ManyToOne(	cascade= {	CascadeType.DETACH,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="client_fk")
	private Client client;

	@ManyToOne( cascade = { CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinColumn(name = "course_pk")
	private Course course;
}