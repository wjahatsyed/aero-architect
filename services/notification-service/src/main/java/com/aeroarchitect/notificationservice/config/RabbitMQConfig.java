package com.aeroarchitect.notificationservice.config;

import com.aeroarchitect.notificationservice.event.BookingCreatedEvent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    public static final String BOOKING_CREATED_QUEUE = "booking.created.queue";

    @Bean
    public Queue bookingCreatedQueue() {
        return new Queue(BOOKING_CREATED_QUEUE, true);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultClassMapper classMapper = new DefaultClassMapper();

        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("com.aeroarchitect.booking_service.event.BookingCreatedEvent", BookingCreatedEvent.class);

        classMapper.setIdClassMapping(idClassMapping);
        converter.setClassMapper(classMapper);

        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
