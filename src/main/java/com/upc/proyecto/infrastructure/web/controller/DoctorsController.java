package com.upc.proyecto.infrastructure.web.controller;

import com.upc.proyecto.application.usecase.DoctorsService;
import com.upc.proyecto.infrastructure.web.dto.doctors.DoctorsRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.upc.proyecto.infrastructure.config.EndPoints.REGISTER_DOCTORS;

@RestController
@RequestMapping()
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @PostMapping(REGISTER_DOCTORS)
    public JsonResponseController<Object> registerController(
            @RequestBody DoctorsRequest doctorsRequest
    ) {
        System.out.println("register controller");
        return doctorsService.RegisterService(doctorsRequest);
    }

    // READ ALL - Obtener todos los doctores
    @GetMapping("/doctors")
    public JsonResponseController<Object> getAllDoctors() {
        return doctorsService.getAllDoctors();
    }

    // READ ONE - Obtener doctor por ID
    @GetMapping("/doctors/{id}")
    public JsonResponseController<Object> getDoctorById(@PathVariable Long id) {
        return doctorsService.getDoctorById(id);
    }

    // UPDATE - Actualizar doctor
    @PutMapping("/doctors/{id}")
    public JsonResponseController<Object> updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorsRequest doctorsRequest
    ) {
        return doctorsService.updateDoctor(id, doctorsRequest);
    }

    // DELETE - Eliminar doctor
    @DeleteMapping("/doctors/{id}")
    public JsonResponseController<Object> deleteDoctor(@PathVariable Long id) {
        return doctorsService.deleteDoctor(id);
    }
}