package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.infrastructure.adapter.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity,String> {
    List<AppointmentEntity> findAll();
}
