package com.upc.proyecto.infrastructure.web.dto.sign;

public record SignUpRequest(
        String name,
        String paternalSurname,
        String maternalSurname,
        String dni,
        String email,
        String password,
        String role
) { }
