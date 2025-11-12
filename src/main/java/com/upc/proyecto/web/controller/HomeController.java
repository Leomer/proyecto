package com.upc.proyecto.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.upc.proyecto.web.constants.EndPoints.HOME;

@RestController
@RequestMapping()
public class HomeController {

    @GetMapping(HOME)
    public void home() {

    }

}
