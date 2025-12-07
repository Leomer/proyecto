package com.upc.proyecto.infrastructure.web.dto.doctors;

public record DoctorsRequest(
        String dni,
        Long specialtyId,
        String cmp,
        boolean enabled,
        String name,
        String paternalSurname,
        String maternalSurname,
        String email,
        String password
) { }
