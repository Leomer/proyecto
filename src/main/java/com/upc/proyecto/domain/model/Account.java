package com.upc.proyecto.domain.model;

import java.time.Instant;

public record Account(
        Long accountId,
        String dni,
        String password,
        String role,
        Instant createdAt,
        boolean status
) {
}
