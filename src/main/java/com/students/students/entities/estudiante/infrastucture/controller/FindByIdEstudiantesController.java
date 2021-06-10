package com.students.students.entities.estudiante.infrastucture.controller;


import com.students.students.entities.estudiante.domain.dto.EstudianteOutputDto;
import com.students.students.entities.estudiante.infrastucture.repository.port.FindByIdEstudiantesPort;
import com.students.students.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindByIdEstudiantesController {

    FindByIdEstudiantesPort findByIdEstudiantesPort;
    @PreAuthorize("hasRole('ESTUDIANTE') || hasRole('PROFESOR')")
    @GetMapping("/api/estudiante/{id}")
    public EstudianteOutputDto findById(@PathVariable("id") String id) {
        return findByIdEstudiantesPort.findById(id);
    }
}
