package com.aeroarchitect.booking_service.messaging;


import com.aeroarchitect.booking_service.config.RabbitMQConfig;
import com.aeroarchitect.booking_service.event.BookingCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishBookingCreatedEvent(BookingCreatedEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.BOOKING_CREATED_QUEUE, event);
    }
}

