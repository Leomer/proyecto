package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Doctor;
import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.domain.port.out.DoctorsRepositoryPort;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.doctors.DoctorsRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorsService {

    private final UserRepositoryPort userRepositoryPort;
    private final DoctorsRepositoryPort doctorsRepositoryPort;

    public JsonResponseController<Object> RegisterService(
            DoctorsRequest  doctorsRequest
    ) {
        String dni = doctorsRequest.dni();
        String email = doctorsRequest.email();

        var userOpt = userRepositoryPort.findFirstByDniOrEmail(dni, email);
        var doctorOpt = doctorsRepositoryPort.findByDni(dni);

        if (!doctorOpt.isEmpty()) {
            return new JsonResponseController<>(1, "DNI ya existe en la BD de doctores", null);
        }

        User user = new User(
                null,
                doctorsRequest.name(),
                doctorsRequest.paternalSurname(),
                doctorsRequest.maternalSurname(),
                doctorsRequest.dni(),
                doctorsRequest.email()
        );
        Doctor doctor = new Doctor(
                null,
                doctorsRequest.dni(),
                doctorsRequest.specialtyId(),
                doctorsRequest.cmp(),
                true
        );

        if (userOpt.isEmpty()) {
            System.out.println("Usuario ya libre");
            var registerUser = userRepositoryPort.save(user);
        }
        var registerDoctor = doctorsRepositoryPort.save(doctor);

        return new JsonResponseController<>(0, "Doctor guardado", doctorsRequest);
    }

}
