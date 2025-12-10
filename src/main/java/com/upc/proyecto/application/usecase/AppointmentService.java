package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Appointment;
import com.upc.proyecto.domain.port.out.AppointmentRepositoryPort;
import com.upc.proyecto.domain.port.out.DoctorsRepositoryPort;
import com.upc.proyecto.domain.port.out.SpecialtyRepositoryPort;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.appointment.AppointmentRequest;
import com.upc.proyecto.infrastructure.web.dto.appointment.AppointmentResponse;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepositoryPort appointmentRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final DoctorsRepositoryPort doctorsRepositoryPort;
    private final SpecialtyRepositoryPort specialtyRepositoryPort;

    public JsonResponseController<Object> AppointmentRegisterService(AppointmentRequest appointmentRequest) {

        String dni = appointmentRequest.dni();

        var userOpt = userRepositoryPort.findByDni(dni);
        var doctorOpt = doctorsRepositoryPort.findByDoctorId(appointmentRequest.doctorId());

        if (userOpt.isEmpty()) {
            return new JsonResponseController<>(0, "Usuario no registrado", null);
        }
        if (doctorOpt.isEmpty()) {
            return new JsonResponseController<>(0, "Doctor no registrado", null);
        }

        var doctor = userRepositoryPort.findByDni(doctorOpt.get().dni());
        var especialty = specialtyRepositoryPort.findById(doctorOpt.get().specialtyId());



        Appointment appointment = new Appointment(
                null,
                userOpt.get().userId(),
                appointmentRequest.holder(),
                appointmentRequest.doctorId().toString(),
                Instant.now(),
                appointmentRequest.appointmentDate(),
                appointmentRequest.appointmentTime(),
                1
        );

        var user = userOpt.get();

        AppointmentResponse appointmentResponse = new AppointmentResponse(
          user.dni(),
                user.name(),
                user.email(),
                appointmentRequest.holder(),
                doctor.get().name(),
                especialty.get().specialtyName(),
                appointmentRequest.appointmentDate(),
                appointmentRequest.appointmentTime()


        );

        appointmentRepositoryPort.save(appointment);

        return new JsonResponseController<>(0, "Cita registrada", appointmentResponse);
    }

    public JsonResponseController<Object> GetAppointmentsService() {

        var appointments = appointmentRepositoryPort.findAll();

        if (appointments.isEmpty()) return new JsonResponseController<>(0, "No appointments found", null);

        return new JsonResponseController<>(200, "OK", appointments);
    }

}
