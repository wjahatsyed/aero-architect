package com.aeroarchitect.booking_service.service.impl;

import com.aeroarchitect.booking_service.event.BookingCreatedEvent;
import com.aeroarchitect.booking_service.messaging.BookingEventPublisher;
import com.aeroarchitect.booking_service.model.Booking;
import com.aeroarchitect.booking_service.repository.BookingRepository;
import com.aeroarchitect.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingEventPublisher bookingEventPublisher;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(Booking.BookingStatus.PENDING);
        Booking saved = bookingRepository.save(booking);

        // Build and publish the event
        BookingCreatedEvent event = new BookingCreatedEvent(
                saved.getId(),
                saved.getPassengerName(),
                saved.getFlightNumber(),
                saved.getSeatNumber(),
                saved.getBookingDate()
        );
        bookingEventPublisher.publishBookingCreatedEvent(event);

        return saved;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
}
