package com.project.application.airportapplicationproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Ticket implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	private Date saleDate;

	@NotNull(message = "Please specify the client")
	@ManyToOne(	cascade= {	CascadeType.DETACH,
							CascadeType.PERSIST},
				fetch=FetchType.LAZY)
	@JoinColumn(name="client_fk")
	private Client client;

	@NotNull(message = "Please specify the course")
	@ManyToOne( cascade = { CascadeType.MERGE,
							CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinColumn(name = "course_pk")
	private Course course;
}