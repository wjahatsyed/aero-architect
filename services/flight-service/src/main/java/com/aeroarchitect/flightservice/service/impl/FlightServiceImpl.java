package com.aeroarchitect.flightservice.service.impl;

import com.aeroarchitect.flightservice.model.Flight;
import com.aeroarchitect.flightservice.repository.FlightRepository;
import com.aeroarchitect.flightservice.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
