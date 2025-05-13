package com.aeroarchitect.flightservice.controller;

import com.aeroarchitect.flightservice.model.Flight;
import com.aeroarchitect.flightservice.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return new ResponseEntity<>(flightService.createFlight(flight), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }
}
