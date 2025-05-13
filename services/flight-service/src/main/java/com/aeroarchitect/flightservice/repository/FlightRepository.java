package com.aeroarchitect.flightservice.repository;

import com.aeroarchitect.flightservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
