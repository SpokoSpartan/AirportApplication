package com.project.application.airportapplicationproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.application.airportapplicationproject.entities.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    @Query("SELECT u FROM Person u WHERE u.email = ?1")
    List<Person> findUsersByEmail(String email);
}
