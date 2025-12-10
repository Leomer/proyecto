package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.Specialty;
import com.upc.proyecto.domain.port.out.SpecialtyRepositoryPort;
import com.upc.proyecto.infrastructure.adapter.entity.SpecialtyEntity;
import com.upc.proyecto.infrastructure.adapter.mapper.SpecialtyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SpecialtyRepositoryAdapter implements SpecialtyRepositoryPort {
    private final JpaSpecialtyRepository jpaSpecialtyRepository;
    private final SpecialtyMapper specialtyMapper;

    @Override
    public List<Specialty> findAll() {
        List<SpecialtyEntity> optionalSpecialty = jpaSpecialtyRepository.findAll();

        return optionalSpecialty.stream()
                .map(specialtyMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Specialty> findById(Long id) {
        Optional<SpecialtyEntity> specialtyEntity = jpaSpecialtyRepository.findBySpecialtyId(id);
        return specialtyEntity.map(specialtyMapper::toDomain);
    }
}
