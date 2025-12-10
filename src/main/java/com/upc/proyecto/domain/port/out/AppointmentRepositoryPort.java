package com.upc.proyecto.domain.port.out;

import com.upc.proyecto.domain.model.Appointment;

public interface AppointmentRepositoryPort {
    Appointment save(Appointment appointment);
}
