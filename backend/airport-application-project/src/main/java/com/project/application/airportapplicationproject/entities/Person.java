package com.project.application.airportapplicationproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

import java.io.Serializable;

@Entity
@Data
public class Person implements Serializable {

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please specify the name")
	private String name;

	@NotBlank(message = "Please specify the surname")
	private String surname;

	@NotBlank(message = "Please specify the id card number")
	private String idCardNumber;

	@NotBlank(message = "Please specify the city")
	private String city;

	@Email(message = "Please enter data in the email form")
	@NotBlank(message = "Please specify the email")
	private String email;

	@Size(min = 9, max = 11, message = "Phone number should be between 9 and 11 character length")
	@NotBlank(message = "Please specify the phone number")
	private String phoneNumber;
}
