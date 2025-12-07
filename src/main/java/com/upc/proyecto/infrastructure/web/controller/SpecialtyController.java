package com.upc.proyecto.infrastructure.web.controller;

import com.upc.proyecto.application.usecase.SpecialtyService;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.upc.proyecto.infrastructure.config.EndPoints.GET_ALL_SPECIALTY;

@RestController
@RequestMapping()
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping(GET_ALL_SPECIALTY)
    public JsonResponseController<Object> getAllSpecialty() {
        System.out.println("getAllSpecialty");
        return specialtyService.GetAllSpecialty();
    }

}
