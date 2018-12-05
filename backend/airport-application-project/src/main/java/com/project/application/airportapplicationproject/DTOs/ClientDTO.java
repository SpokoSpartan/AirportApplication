package com.project.application.airportapplicationproject.DTOs;

import com.project.application.airportapplicationproject.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotNull(message = "Please specify the person")
    private Person person;
}
