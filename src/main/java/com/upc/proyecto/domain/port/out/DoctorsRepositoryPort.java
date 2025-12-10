package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorsRepositoryPort {
    Optional<Doctor> findByDni(String dni);
    Optional<Doctor> findByDoctorId(Long doctorId);
    Doctor save(Doctor doctor);
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    void deleteById(Long id);
}
