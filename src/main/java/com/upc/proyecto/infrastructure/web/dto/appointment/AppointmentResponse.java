package com.upc.proyecto.infrastructure.web.dto.appointment;

public record AppointmentResponse(
        String dni,
        String name,
        String email,
        String holder,
        String doctorName,
        String specialty,
        String appointmentDate,
        String appointmentTime
) { }
