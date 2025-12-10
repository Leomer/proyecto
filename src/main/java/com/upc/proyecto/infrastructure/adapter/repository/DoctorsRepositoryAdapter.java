package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.Doctor;
import com.upc.proyecto.domain.port.out.DoctorsRepositoryPort;
import com.upc.proyecto.infrastructure.adapter.entity.DoctorEntity;
import com.upc.proyecto.infrastructure.adapter.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DoctorsRepositoryAdapter implements DoctorsRepositoryPort {
    private final JpaDoctorsRepository  jpaDoctorsRepository;
    private final DoctorMapper doctorMapper;


    @Override
    public Optional<Doctor> findByDni(String dni) {
        Optional<DoctorEntity> doctorEntity = jpaDoctorsRepository.findByDni(dni);
        return doctorEntity.map(doctorMapper::toDomain);
    }

    @Override
    public Optional<Doctor> findByDoctorId(Long doctorId) {
        Optional<DoctorEntity> doctorEntity = jpaDoctorsRepository.findByDoctorId(doctorId);
        return doctorEntity.map(doctorMapper::toDomain);
    }

    @Override
    public Doctor save(Doctor doctor) {
        DoctorEntity doctorEntity = doctorMapper.toEntity(doctor);
        doctorEntity = jpaDoctorsRepository.save(doctorEntity);
        return doctorMapper.toDomain(doctorEntity);
    }
}
