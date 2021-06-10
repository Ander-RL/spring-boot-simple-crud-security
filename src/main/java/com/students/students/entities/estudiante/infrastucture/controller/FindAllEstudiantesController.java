package com.students.students.entities.estudiante.infrastucture.controller;

import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindAllEstudiantesPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindAllEstudiantesController {

    private FindAllEstudiantesPort findEstudiantePort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/estudiante")
    public List<EstudianteOutputDto> findAll() {
        return findEstudiantePort.findAll();
    }
}
