package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Doctor;

import java.util.Optional;

public interface DoctorsRepositoryPort {
    Optional<Doctor> findByDni(String dni);
    Doctor save(Doctor doctor);
}
