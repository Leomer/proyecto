package com.upc.proyecto.infrastructure.web.controller;

import com.upc.proyecto.application.usecase.DoctorsService;
import com.upc.proyecto.infrastructure.web.dto.doctors.DoctorsRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
