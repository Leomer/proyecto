package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Specialty;

import java.util.List;


public interface SpecialtyRepositoryPort {
    List<Specialty> findAll();
}
