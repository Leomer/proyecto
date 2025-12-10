package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.infrastructure.adapter.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity,String> {
}
