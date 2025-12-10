package com.upc.proyecto.domain.model;

import java.time.Instant;

public record Appointment(
        Long appointmentId,

        Long userId,
        String holder,
        String doctorId,
        Instant createdAt,
        String appointmentDate,
        String appointmentTime,
        Integer status
) { }
