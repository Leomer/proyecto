package com.upc.proyecto.infrastructure.web.dto.doctors;

public record DoctorsResponse(
        Long doctorId,
        String dni,
        Long specialtyId,
        String cmp,
        boolean enabled
) {}