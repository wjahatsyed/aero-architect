package com.aeroarchitect.notificationservice.messaging;

import com.aeroarchitect.notificationservice.event.BookingCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookingCreatedListener {

    @RabbitListener(queues = "booking.created.queue")
    public void handleBookingCreated(BookingCreatedEvent event) {
        log.info("Received BookingCreatedEvent in notification-service:");
        log.info("Passenger: {}, Flight: {}, Seat: {}", event.getPassengerName(), event.getFlightNumber(), event.getSeatNumber());

        // Simulate sending email or SMS notification
        log.info("Sending notification to {} for flight {} on {}", event.getPassengerName(), event.getFlightNumber(), event.getBookingDate());
    }
}
