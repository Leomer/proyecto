package com.upc.proyecto.infrastructure.web.dto.sign;

public record SignInRequest(
        String dni,
        String password
) {}
