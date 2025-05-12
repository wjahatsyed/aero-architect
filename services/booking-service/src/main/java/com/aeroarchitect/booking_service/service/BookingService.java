package com.aeroarchitect.booking_service.service;

import com.aeroarchitect.booking_service.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Optional<Booking> getBookingById(Long id);
}

