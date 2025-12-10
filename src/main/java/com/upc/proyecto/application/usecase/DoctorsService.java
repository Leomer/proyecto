package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.model.Doctor;
import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.domain.port.out.DoctorsRepositoryPort;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.web.dto.doctors.DoctorsRequest;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.upc.proyecto.infrastructure.web.dto.doctors.DoctorsResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorsService {

    private final UserRepositoryPort userRepositoryPort;
    private final DoctorsRepositoryPort doctorsRepositoryPort;

    public JsonResponseController<Object> RegisterService(
            DoctorsRequest doctorsRequest
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

    // READ ALL - Obtener todos los doctores
    public JsonResponseController<Object> getAllDoctors() {
        try {
            List<Doctor> doctors = doctorsRepositoryPort.findAll();

            List<DoctorsResponse> response = doctors.stream()
                    .map(doctor -> new DoctorsResponse(
                            doctor.doctorId(),
                            doctor.dni(),
                            doctor.specialtyId(),
                            doctor.cmp(),
                            doctor.enabled()
                    ))
                    .collect(Collectors.toList());

            return new JsonResponseController<>(0, "Doctores obtenidos", response);
        } catch (Exception e) {
            return new JsonResponseController<>(1, "Error al obtener doctores", null);
        }
    }

    // READ ONE - Obtener doctor por ID
    public JsonResponseController<Object> getDoctorById(Long id) {
        try {
            Optional<Doctor> doctor = doctorsRepositoryPort.findById(id);

            if (doctor.isEmpty()) {
                return new JsonResponseController<>(1, "Doctor no encontrado", null);
            }

            Doctor d = doctor.get();
            DoctorsResponse response = new DoctorsResponse(
                    d.doctorId(),
                    d.dni(),
                    d.specialtyId(),
                    d.cmp(),
                    d.enabled()
            );

            return new JsonResponseController<>(0, "Doctor encontrado", response);
        } catch (Exception e) {
            return new JsonResponseController<>(1, "Error al obtener doctor", null);
        }
    }

    // UPDATE - Actualizar doctor
    public JsonResponseController<Object> updateDoctor(Long id, DoctorsRequest request) {
        try {
            Optional<Doctor> existingDoctor = doctorsRepositoryPort.findById(id);

            if (existingDoctor.isEmpty()) {
                return new JsonResponseController<>(1, "Doctor no encontrado", null);
            }

            Doctor updatedDoctor = new Doctor(
                    id,
                    request.dni(),
                    request.specialtyId(),
                    request.cmp(),
                    request.enabled()
            );

            doctorsRepositoryPort.save(updatedDoctor);

            return new JsonResponseController<>(0, "Doctor actualizado", null);
        } catch (Exception e) {
            return new JsonResponseController<>(1, "Error al actualizar doctor", null);
        }
    }

    // DELETE - Eliminar doctor
    public JsonResponseController<Object> deleteDoctor(Long id) {
        try {
            Optional<Doctor> doctor = doctorsRepositoryPort.findById(id);

            if (doctor.isEmpty()) {
                return new JsonResponseController<>(1, "Doctor no encontrado", null);
            }

            doctorsRepositoryPort.deleteById(id);

            return new JsonResponseController<>(0, "Doctor eliminado", null);
        } catch (Exception e) {
            return new JsonResponseController<>(1, "Error al eliminar doctor", null);
        }
    }
}