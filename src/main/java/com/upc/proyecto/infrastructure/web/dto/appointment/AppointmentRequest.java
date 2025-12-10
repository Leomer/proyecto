package com.upc.proyecto.infrastructure.web.dto.appointment;

import java.time.Instant;

public record AppointmentRequest(
        String dni,
        String holder,
        Long doctorId,
        String appointmentDate,
        String appointmentTime
) { }
