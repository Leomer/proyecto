package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findByDni(String dni);
}
