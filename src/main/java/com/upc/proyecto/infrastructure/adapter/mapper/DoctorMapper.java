package com.upc.proyecto.infrastructure.adapter.mapper;

import com.upc.proyecto.domain.model.Doctor;
import com.upc.proyecto.infrastructure.adapter.entity.DoctorEntity;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toDomain(DoctorEntity doctorEntity){
        return new Doctor(
                doctorEntity.getDoctorId(),
                doctorEntity.getDni(),
                doctorEntity.getSpecialtyId(),
                doctorEntity.getCmp(),
                doctorEntity.isEnabled()
        );
    }

    public DoctorEntity toEntity(Doctor doctor){
        return new DoctorEntity(
                doctor.doctorId(),
                doctor.dni(),
                doctor.specialtyId(),
                doctor.cmp(),
                doctor.enabled()
        );
    }

}
