package com.upc.proyecto.domain.model.sign;

public record SignInRequest(
        String dni,
        String password
) {}
