package com.upc.proyecto.application.usecase;

import com.upc.proyecto.domain.port.out.SpecialtyRepositoryPort;
import com.upc.proyecto.infrastructure.web.response.JsonResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepositoryPort specialtyRepositoryPort;

    public JsonResponseController<Object>GetAllSpecialty() {
        System.out.println("getAllSpecialty");
        var specialtyList = specialtyRepositoryPort.findAll();

        if  (specialtyList.isEmpty()) {
            return new JsonResponseController<>(0, "No hay especialidades", null);
        }

        return new JsonResponseController<>(0, "", specialtyList);
    }
}
