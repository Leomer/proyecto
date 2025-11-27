package com.upc.proyecto.application.service;

import com.upc.proyecto.domain.model.sign.SignInRequest;
import com.upc.proyecto.domain.model.sign.SignUpRequest;
import com.upc.proyecto.infrastructure.response.JsonResponseController;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    public JsonResponseController<Object> SignInService(
            SignInRequest signInRequest
    ) {
        System.out.println("SignInService");
        return new JsonResponseController<>(0,"message",signInRequest);
    }

    public JsonResponseController<Object> SignUpService(
            SignUpRequest signUpRequest
    ) {
        System.out.println("SignUpService");
        return null;
    }

    public JsonResponseController<Object> SignUpdateService() {
        System.out.println("SignUpdateService");
        return null;
    }
}
