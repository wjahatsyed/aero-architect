package com.aeroarchitect.booking_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @GetMapping
    public ResponseEntity<String> getBookings() {
        return ResponseEntity.ok("Booking list placeholder");
    }
}
