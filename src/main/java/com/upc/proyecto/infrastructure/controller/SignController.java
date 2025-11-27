package com.upc.proyecto.infrastructure.controller;

import com.upc.proyecto.application.service.SignService;
import com.upc.proyecto.domain.model.sign.SignInRequest;
import com.upc.proyecto.domain.model.sign.SignUpRequest;
import com.upc.proyecto.infrastructure.response.JsonResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.upc.proyecto.infrastructure.config.EndPoints.*;

@RestController
@RequestMapping()
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping(SIGNIN)
    public JsonResponseController<Object> signInController(
            @RequestBody SignInRequest signInRequest
    ) {
        System.out.println("signInController");
        return signService.SignInService(signInRequest);
    }

    @PostMapping(SIGNUP)
    public JsonResponseController<Object> signUpController(
            @RequestBody SignUpRequest signUpRequest
    ) {
        System.out.println("signUpController");
        return signService.SignUpService(signUpRequest);
    }

    @PostMapping(SIGNUPDATE)
    public JsonResponseController<Object> signUpdateController() {
        System.out.println("signUpdateController");
        return signService.SignUpdateService();
    }

}
