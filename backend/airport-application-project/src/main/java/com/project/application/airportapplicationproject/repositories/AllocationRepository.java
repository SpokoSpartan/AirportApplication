package com.project.application.airportapplicationproject.repositories;

import com.project.application.airportapplicationproject.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}
