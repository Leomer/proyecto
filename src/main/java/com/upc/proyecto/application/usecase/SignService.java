package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Account;
import com.upc.proyecto.domain.port.out.AccountRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.sign.SignInRequest;
import com.upc.proyecto.infrastructure.web.dto.sign.SignUpRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignService {

    private final AccountRepositoryPort accountRepositoryPort;

    public JsonResponseController<Object> SignInService(
            SignInRequest signInRequest
    ) {
        System.out.println("SignInService");

        var accountOpt = accountRepositoryPort.findByDni(signInRequest.dni());

        if (accountOpt.isEmpty()) {
            return new JsonResponseController<>(1, "Usuario no registrado", null);
        }

        Account account = accountOpt.get();
        if (!account.password().equals(signInRequest.password())) {
            return new JsonResponseController<>(1,"Password incorrecto",null);
        }

        return new JsonResponseController<>(0,"message",account);
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
