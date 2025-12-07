package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Account;
import com.upc.proyecto.domain.model.User;

import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findByDni(String dni);
    Account save(Account account);
}
