package com.project.application.airportapplicationproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private String name;
	private String surname;
	private String idCardNumber;
	private String city;
	private String email;
	private String phoneNumber;
}
