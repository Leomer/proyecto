package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Appointment;
import com.upc.proyecto.domain.port.out.AppointmentRepositoryPort;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.appointment.AppointmentRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepositoryPort appointmentRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public JsonResponseController<Object> AppointmentRegisterService(AppointmentRequest appointmentRequest) {

        String dni = appointmentRequest.dni();

        var userOpt = userRepositoryPort.findByDni(dni);

        if (userOpt.isEmpty()) {
            return new JsonResponseController<>(0, "Usuario no registrado", null);
        }

        Appointment appointment = new Appointment(
                null,
                userOpt.get().userId(),
                appointmentRequest.holder(),
                appointmentRequest.doctorId(),
                Instant.now(),
                appointmentRequest.appointmentDate(),
                appointmentRequest.appointmentTime(),
                1
        );

        var registerAppointment = appointmentRepositoryPort.save(appointment);

        return new JsonResponseController<>(0, "Cita registrada", registerAppointment);
    }
}
