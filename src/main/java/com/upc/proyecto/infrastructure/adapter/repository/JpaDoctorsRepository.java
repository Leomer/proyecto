package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.Doctor;
import com.upc.proyecto.infrastructure.adapter.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaDoctorsRepository extends JpaRepository<DoctorEntity,Long> {
    Optional<DoctorEntity> findByDni(String dni);
    Optional<DoctorEntity> findByDoctorId(Long doctorId);
}
