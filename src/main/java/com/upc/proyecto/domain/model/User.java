package com.upc.proyecto.domain.model;

import java.time.Instant;

public record User(
        Long userId,
        String name,
        String paternalSurname,
        String maternalSurname,
        String dni,
        String email
) { }
