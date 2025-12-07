package com.upc.proyecto.infrastructure.adapter.mapper;

import com.upc.proyecto.domain.model.Specialty;
import com.upc.proyecto.infrastructure.adapter.entity.SpecialtyEntity;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyMapper {

    public Specialty toDomain(SpecialtyEntity specialtyEntity) {
        return new Specialty(
                specialtyEntity.getSpecialtyId(),
                specialtyEntity.getSpecialtyName()
        );
    }
}
