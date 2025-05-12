package com.aeroarchitect.booking_service.controller;

import com.aeroarchitect.booking_service.model.Booking;
import com.aeroarchitect.booking_service.repository.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        bookingRepository.deleteAll(); // clean DB before each test
    }

    @Test
    void shouldCreateAndRetrieveBooking() throws Exception {
        Booking booking = new Booking();
        booking.setPassengerName("Wajahat");
        booking.setFlightNumber("QR805");
        booking.setSeatNumber("12A");

        // POST /api/bookings
        String response = mockMvc.perform(post("/api/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(booking)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.passengerName").value("Wajahat"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Booking saved = objectMapper.readValue(response, Booking.class);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getStatus()).isEqualTo(Booking.BookingStatus.PENDING);

        // GET /api/bookings
        mockMvc.perform(get("/api/bookings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}

