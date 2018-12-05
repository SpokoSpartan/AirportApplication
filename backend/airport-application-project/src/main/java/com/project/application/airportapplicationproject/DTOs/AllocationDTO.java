package com.project.application.airportapplicationproject.DTOs;

import com.project.application.airportapplicationproject.entities.Employee;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllocationDTO {

    @NotNull(message = "Please specify the employee")
    private Employee employee;
}
