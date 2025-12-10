package com.upc.proyecto.infrastructure.web.controller;

import com.upc.proyecto.application.usecase.AppointmentService;
import com.upc.proyecto.infrastructure.web.dto.appointment.AppointmentRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.upc.proyecto.infrastructure.config.EndPoints.GET_APPOINTMENTS;
import static com.upc.proyecto.infrastructure.config.EndPoints.REGISTER_APPOINTMENT;

@RestController
@RequestMapping()
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping(REGISTER_APPOINTMENT)
    public JsonResponseController<Object> registerAppointment(
            @RequestBody AppointmentRequest appointmentRequest
    ){
        return appointmentService.AppointmentRegisterService(appointmentRequest);
    }

    @GetMapping(GET_APPOINTMENTS)
    public JsonResponseController<Object> getAppointments() {
        return appointmentService.GetAppointmentsService();
    }
}
