package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Specialty;

import java.util.List;
import java.util.Optional;


public interface SpecialtyRepositoryPort {
    List<Specialty> findAll();
    Optional<Specialty> findById(Long id);
}
