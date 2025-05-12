package com.aeroarchitect.booking_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreatedEvent {
    private Long bookingId;
    private String passengerName;
    private String flightNumber;
    private String seatNumber;
    private LocalDate bookingDate;
}

