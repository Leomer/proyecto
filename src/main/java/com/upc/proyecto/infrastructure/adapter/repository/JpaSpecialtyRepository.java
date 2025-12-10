package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.infrastructure.adapter.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaSpecialtyRepository extends JpaRepository<SpecialtyEntity,String> {
    List<SpecialtyEntity> findAll();
    Optional<SpecialtyEntity> findBySpecialtyId(Long id);
}
