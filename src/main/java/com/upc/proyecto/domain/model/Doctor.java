package com.upc.proyecto.domain.model;

public record Doctor(
        Long doctorId,
        String dni,
        Long specialtyId,
        String cmp,
        boolean enabled
) { }
