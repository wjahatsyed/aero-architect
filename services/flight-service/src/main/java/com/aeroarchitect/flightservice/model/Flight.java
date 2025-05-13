package com.aeroarchitect.flightservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String origin;
    private String destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        SCHEDULED,
        DELAYED,
        CANCELLED,
        LANDED
    }
}
