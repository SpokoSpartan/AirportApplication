package com.project.application.airportapplicationproject.repositories;

import com.project.application.airportapplicationproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
