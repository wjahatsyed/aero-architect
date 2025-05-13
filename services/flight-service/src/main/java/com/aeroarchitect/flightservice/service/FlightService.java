package com.aeroarchitect.flightservice.service;

import com.aeroarchitect.flightservice.model.Flight;

import java.util.List;

public interface FlightService {
    Flight createFlight(Flight flight);
    List<Flight> getAllFlights();
}
