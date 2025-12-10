package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.Appointment;
import com.upc.proyecto.domain.port.out.AppointmentRepositoryPort;
import com.upc.proyecto.infrastructure.adapter.entity.AppointmentEntity;
import com.upc.proyecto.infrastructure.adapter.mapper.AppointmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AppointmentRepositoryAdapter implements AppointmentRepositoryPort {
    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public List<Appointment> findAll() {
        List<AppointmentEntity> appointmentEntities = jpaAppointmentRepository.findAll();
        return appointmentEntities.stream()
                .map(appointmentMapper::toDomain)
                .toList();
    }

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentEntity appointmentEntity = appointmentMapper.toEntity(appointment);
        appointmentEntity = jpaAppointmentRepository.save(appointmentEntity);
        return appointmentMapper.toDomain(appointmentEntity);
    }
}
