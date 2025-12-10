package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Appointment;

import java.util.List;

public interface AppointmentRepositoryPort {
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
}
