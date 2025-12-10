package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findFirstByDniOrEmail(String dni, String email);
    Optional<User> findByDni(String dni);
    User save(User user);
}
