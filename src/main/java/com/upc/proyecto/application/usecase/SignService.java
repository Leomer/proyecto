package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Account;
import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.domain.port.out.AccountRepositoryPort;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.sign.SignInRequest;
import com.upc.proyecto.infrastructure.web.dto.sign.SignUpRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SignService {

    private final AccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

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
        String dni = signUpRequest.dni();
        String email = signUpRequest.email();

        System.out.println("SignUpService");

        var userOpt = userRepositoryPort.findFirstByDniOrEmail(dni, email);
        if (!userOpt.isEmpty()) {
            return new JsonResponseController<>(1, "DNI o Correo ya existe", null);
        }

        User user = new User(
                null,
                signUpRequest.name(),
                signUpRequest.paternalSurname(),
                signUpRequest.maternalSurname(),
                signUpRequest.dni(),
                signUpRequest.email());

        Account account = new Account(
                null,
                signUpRequest.dni(),
                signUpRequest.password(),
                signUpRequest.role(),
                Instant.now(),
                true);

        var registerUser = userRepositoryPort.save(user);
        var registerAccount = accountRepositoryPort.save(account);

        System.out.println("RegisterUser: " + registerUser);
        System.out.println("RegisterAccount: " + registerAccount);

        return new JsonResponseController<>(0, "Registro OK", null);
    }

    public JsonResponseController<Object> SignUpdateService() {
        System.out.println("SignUpdateService");
        return null;
    }
}
