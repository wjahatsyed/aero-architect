package com.aeroarchitect.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/booking")
    public ResponseEntity<String> bookingFallback() {
        return ResponseEntity.ok("Booking Service is temporarily unavailable.");
    }

    @GetMapping("/flight")
    public ResponseEntity<String> flightFallback() {
        return ResponseEntity.ok("Flight Service is temporarily unavailable.");
    }
}
