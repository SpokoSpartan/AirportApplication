package com.project.application.airportapplicationproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.application.airportapplicationproject.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
}
