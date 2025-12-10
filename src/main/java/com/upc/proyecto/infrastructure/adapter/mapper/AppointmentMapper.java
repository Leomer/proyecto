package com.upc.proyecto.infrastructure.adapter.mapper;

import com.upc.proyecto.domain.model.Appointment;
import com.upc.proyecto.infrastructure.adapter.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toDomain(AppointmentEntity entity) {
        return new Appointment(
                entity.getAppointmentId(),
                entity.getUserId(),
                entity.getHolder(),
                entity.getDoctorId(),
                entity.getCreatedAt(),
                entity.getAppointmentDate(),
                entity.getAppointmentTime(),
                entity.getStatus()
        );
    }
    public AppointmentEntity toEntity(Appointment appointment) {
        return new AppointmentEntity(
                appointment.appointmentId(),
                appointment.userId(),
                appointment.holder(),
                appointment.doctorId(),
                appointment.createdAt(),
                appointment.appointmentDate(),
                appointment.appointmentTime(),
                appointment.status()
        );
    }
}
